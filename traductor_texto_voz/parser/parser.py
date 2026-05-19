from __future__ import annotations

from typing import List
from errors.error_handler import ErrorHandler
from errors.error_types import ERRORES_SINTACTICOS
from lexer.Scanner import Scanner
from lexer.Token import Token
from lexer.TokenType import TokenType
from parser.ast_nodes import ClauseNode, NumberNode, PhraseNode, SentenceNode, TextNode, WordNode


class ParserWrapper:
    def __init__(self, error_handler: ErrorHandler):
        self.error_handler = error_handler
        self.tokens: List[Token] = []
        self.current = 0
        self.source_text = ""

    def parse(self, texto: str) -> TextNode | None:
        scanner = Scanner(texto, self.error_handler)
        tokens = scanner.escanear()
        return self.parse_tokens(texto, tokens)

    def parse_tokens(self, texto: str, tokens: List[Token]) -> TextNode | None:
        self.source_text = texto
        self.tokens = tokens
        self.current = 0
        if self.error_handler.has_errors:
            return None
        sentences = []
        while not self.is_at_end():
            sentence = self.sentence()
            if sentence is None:
                self.synchronize()
            else:
                sentences.append(sentence)
        return TextNode(sentences=sentences)

    def sentence(self) -> SentenceNode | None:
        if self.match(TokenType.LQN):
            start = self.previous()
            clause = self.clause()
            end = self.consume(TokenType.RQN, "Se esperaba '?' al final de la pregunta")
            if clause is None or end is None:
                return None
            return SentenceNode(
                tipo="question",
                clause=clause,
                punctuation="?",
                raw_text=self.source_from(start, end),
                linea=start.linea,
                columna=start.columna,
            )
        if self.match(TokenType.LEXCL):
            start = self.previous()
            clause = self.clause()
            end = self.consume(TokenType.REXCL, "Se esperaba '!' al final de la exclamación")
            if clause is None or end is None:
                return None
            return SentenceNode(
                tipo="exclamation",
                clause=clause,
                punctuation="!",
                raw_text=self.source_from(start, end),
                linea=start.linea,
                columna=start.columna,
            )
        if self.check(TokenType.EOF):
            return None
        start = self.peek()
        clause = self.clause()
        punct = ""
        end = self.previous()
        if self.match(TokenType.PUNCT):
            punct = self.previous().lexema
            end = self.previous()
        if clause is None:
            return None
        return SentenceNode(
            tipo="declarative",
            clause=clause,
            punctuation=punct,
            raw_text=self.source_from(start, end),
            linea=start.linea,
            columna=start.columna,
        )

    def clause(self) -> ClauseNode | None:
        first = self.phrase()
        if first is None:
            tok = self.peek()
            self.error_handler.report(
                ERRORES_SINTACTICOS["EMPTY_SENTENCE"],
                "Se esperaba una cláusula no vacía",
                tok.linea,
                tok.columna,
            )
            return None
        phrases = [first]
        conjunctions = []
        while self.match(TokenType.CONJ):
            conj = self.previous().lexema
            right = self.phrase()
            if right is None:
                tok = self.peek()
                self.error_handler.report(
                    ERRORES_SINTACTICOS["MISSING_TOKEN"],
                    f"Se esperaba una frase después de la conjunción '{conj}'",
                    tok.linea,
                    tok.columna,
                )
                return None
            conjunctions.append(conj)
            phrases.append(right)
        return ClauseNode(phrases=phrases, conjunctions=conjunctions, linea=first.linea, columna=first.columna)

    def phrase(self) -> PhraseNode | None:
        terms = []
        start = self.peek()
        while self.match(TokenType.WORD, TokenType.NUMBER):
            token = self.previous()
            if token.type == TokenType.WORD:
                terms.append(WordNode(valor=token.lexema, linea=token.linea, columna=token.columna))
            else:
                terms.append(NumberNode(valor=token.lexema, linea=token.linea, columna=token.columna))
        if not terms:
            return None
        return PhraseNode(terms=terms, linea=start.linea, columna=start.columna)

    def synchronize(self) -> None:
        while not self.is_at_end():
            if self.peek().type in (TokenType.PUNCT, TokenType.RQN, TokenType.REXCL):
                self.advance()
                return
            self.advance()

    def source_from(self, start: Token, end: Token) -> str:
        filtered = [t.lexema for t in self.tokens if (t.linea > start.linea or (t.linea == start.linea and t.columna >= start.columna))
                    and (t.linea < end.linea or (t.linea == end.linea and t.columna <= end.columna))
                    and t.type != TokenType.EOF]
        if not filtered:
            return ""
        out = []
        for idx, item in enumerate(filtered):
            if idx == 0:
                out.append(item)
            elif item in {'?', '!', '.', ',', ':', ';'}:
                out.append(item)
            else:
                out.append(' ' + item)
        return ''.join(out)

    def match(self, *types: TokenType) -> bool:
        for token_type in types:
            if self.check(token_type):
                self.advance()
                return True
        return False

    def consume(self, token_type: TokenType, message: str) -> Token | None:
        if self.check(token_type):
            return self.advance()
        tok = self.peek()
        self.error_handler.report(ERRORES_SINTACTICOS["MISSING_TOKEN"], message, tok.linea, tok.columna, tok)
        return None

    def check(self, token_type: TokenType) -> bool:
        if self.is_at_end():
            return token_type == TokenType.EOF
        return self.peek().type == token_type

    def advance(self) -> Token:
        if not self.is_at_end():
            self.current += 1
        return self.previous()

    def is_at_end(self) -> bool:
        return self.peek().type == TokenType.EOF

    def peek(self) -> Token:
        return self.tokens[self.current]

    def previous(self) -> Token:
        return self.tokens[self.current - 1]
