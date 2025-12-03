from dataclasses import dataclass
from typing import Any
from .TokenType import TokenType

@dataclass
class Token:
    type: TokenType
    lexema: Any
    linea: int
    columna: int
    posicion: int = 0  # índice absoluto opcional

    def __str__(self) -> str:
        return f"Token({self.type.name}, {repr(self.lexema)}, linea={self.linea}, columna={self.columna})"
