from typing import List, Dict
from antlr4 import InputStream, CommonTokenStream
from EaV2Lexer import EaV2Lexer  # generado por ANTLR
from .Token import Token
from .TokenType import TokenType

class Scanner:
    """Envuelve al lexer de ANTLR (EaV2Lexer) y lo convierte
    en una lista de Token propios con TokenType.
    """
    def __init__(self, fuente: str):
        self.fuente = fuente
        self.tokens: List[Token] = []

    def escanear(self) -> List[Token]:
        input_stream = InputStream(self.fuente)
        antlr_lexer = EaV2Lexer(input_stream)
        token_stream = CommonTokenStream(antlr_lexer)
        token_stream.fill()

        tipo_mapa: Dict[int, TokenType] = {
            EaV2Lexer.WORD: TokenType.WORD,
            EaV2Lexer.NUMBER: TokenType.NUMBER,
            EaV2Lexer.PUNCT: TokenType.PUNCT,
            EaV2Lexer.LEXCL: TokenType.LEXCL,
            EaV2Lexer.REXCL: TokenType.REXCL,
            EaV2Lexer.LQN: TokenType.LQN,
            EaV2Lexer.RQN: TokenType.RQN,
            EaV2Lexer.LPAREN: TokenType.LPAREN,
            EaV2Lexer.RPAREN: TokenType.RPAREN,
            EaV2Lexer.CONJ: TokenType.CONJ,
        }

        for t in token_stream.tokens:
            if t.type == -1:  # EOF de ANTLR
                self.tokens.append(Token(TokenType.EOF, "<EOF>", t.line, t.column))
                break

            tipo = tipo_mapa.get(t.type)
            if tipo is None:
                # Aquí podrías reportar error léxico si quieres
                continue

            self.tokens.append(
                Token(
                    type=tipo,
                    lexema=t.text,
                    linea=t.line,
                    columna=t.column,
                )
            )

        return self.tokens
