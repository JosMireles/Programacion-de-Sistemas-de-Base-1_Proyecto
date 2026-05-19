from __future__ import annotations

from typing import List
from .Token import Token
from .TokenType import TokenType
from errors.error_handler import ErrorHandler
from errors.error_types import ERRORES_LEXICOS


class Scanner:
    CONJUNCIONES = {"y", "o", "pero"}

    def __init__(self, fuente: str, error_handler: ErrorHandler | None = None):
        self.fuente = fuente
        self.error_handler = error_handler
        self.tokens: List[Token] = []

    @staticmethod
    def _is_word_char(ch: str) -> bool:
        return ch.isalpha() or ch in "áéíóúÁÉÍÓÚñÑüÜ"

    def escanear(self) -> List[Token]:
        self.tokens = []
        i = 0
        linea = 1
        columna = 1
        text = self.fuente
        while i < len(text):
            ch = text[i]
            if ch in " \t":
                i += 1
                columna += 1
                continue
            if ch == "\n":
                i += 1
                linea += 1
                columna = 1
                continue
            if ch == "¡":
                self.tokens.append(Token(TokenType.LEXCL, ch, linea, columna))
                i += 1
                columna += 1
                continue
            if ch == "!":
                self.tokens.append(Token(TokenType.REXCL, ch, linea, columna))
                i += 1
                columna += 1
                continue
            if ch == "¿":
                self.tokens.append(Token(TokenType.LQN, ch, linea, columna))
                i += 1
                columna += 1
                continue
            if ch == "?":
                self.tokens.append(Token(TokenType.RQN, ch, linea, columna))
                i += 1
                columna += 1
                continue
            if ch in ".,:;":
                self.tokens.append(Token(TokenType.PUNCT, ch, linea, columna))
                i += 1
                columna += 1
                continue
            if ch.isdigit():
                start = i
                start_col = columna
                while i < len(text) and text[i].isdigit():
                    i += 1
                    columna += 1
                self.tokens.append(Token(TokenType.NUMBER, text[start:i], linea, start_col))
                continue
            if self._is_word_char(ch):
                start = i
                start_col = columna
                while i < len(text) and self._is_word_char(text[i]):
                    i += 1
                    columna += 1
                lex = text[start:i]
                tok_type = TokenType.CONJ if lex.lower() in self.CONJUNCIONES else TokenType.WORD
                self.tokens.append(Token(tok_type, lex, linea, start_col))
                continue

            if self.error_handler is not None:
                self.error_handler.report(
                    ERRORES_LEXICOS["UNKNOWN_CHAR"],
                    f"Carácter no reconocido: '{ch}'",
                    linea,
                    columna,
                )
            i += 1
            columna += 1

        self.tokens.append(Token(TokenType.EOF, "<EOF>", linea, columna))
        return self.tokens
