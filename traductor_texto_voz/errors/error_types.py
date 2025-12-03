from enum import Enum, auto
from dataclasses import dataclass
from typing import Optional, Any
from lexer.Token import Token

class NivelError(Enum):
    WARNING = auto()
    ERROR = auto()
    FATAL = auto()

class FaseError(Enum):
    LEXICO = "Léxico"
    SINTACTICO = "Sintáctico"
    SEMANTICO = "Semántico"

@dataclass
class ErrorCode:
    codigo: str
    descripcion: str
    nivel: NivelError
    fase: FaseError

ERRORES_LEXICOS = {
    "UNKNOWN_CHAR": ErrorCode("L001", "Carácter desconocido", NivelError.ERROR, FaseError.LEXICO),
}

ERRORES_SINTACTICOS = {
    "UNEXPECTED_TOKEN": ErrorCode("S001", "Token inesperado", NivelError.ERROR, FaseError.SINTACTICO),
    "MISSING_TOKEN": ErrorCode("S002", "Token esperado no encontrado", NivelError.ERROR, FaseError.SINTACTICO),
}

ERRORES_SEMANTICOS = {
    "GENERIC_SEMANTIC": ErrorCode("E001", "Error semántico genérico", NivelError.ERROR, FaseError.SEMANTICO),
}

@dataclass
class CompilerError:
    error_codigo: ErrorCode
    mensaje: str
    linea: int
    columna: int
    token: Optional[Token] = None
    contexto: Optional[Any] = None

    def __str__(self) -> str:
        return (
            f"[{self.error_codigo.fase.value}] "
            f"{self.error_codigo.codigo} - {self.error_codigo.descripcion}: "
            f"{self.mensaje} (línea {self.linea}, columna {self.columna})"
        )
