from dataclasses import dataclass
from .TokenType import TokenType

@dataclass
class Token:
    type: TokenType
    lexema: str
    linea: int
    columna: int

    def __str__(self) -> str:
        return f"{self.type.name}('{self.lexema}') @ {self.linea}:{self.columna}"
