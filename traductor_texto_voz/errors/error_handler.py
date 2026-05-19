from typing import List
from .error_types import CompilerError, ErrorCode, NivelError


class ErrorHandler:
    def __init__(self) -> None:
        self.errors: List[CompilerError] = []
        self.warnings: List[CompilerError] = []

    @property
    def has_errors(self) -> bool:
        return bool(self.errors)

    @property
    def has_warnings(self) -> bool:
        return bool(self.warnings)

    def add_error(self, error: CompilerError) -> None:
        self.errors.append(error)

    def add_warning(self, warning: CompilerError) -> None:
        self.warnings.append(warning)

    def report(self, error_code: ErrorCode, mensaje: str, linea: int, columna: int, token=None, contexto=None) -> None:
        item = CompilerError(error_code, mensaje, linea, columna, token, contexto)
        if error_code.nivel == NivelError.WARNING:
            self.add_warning(item)
        else:
            self.add_error(item)
