from typing import List
from .error_types import CompilerError, NivelError, ErrorCode

class ErrorHandler:
    def __init__(self) -> None:
        self.errors: List[CompilerError] = []
        self.warnings: List[CompilerError] = []

    @property
    def has_errors(self) -> bool:
        return len(self.errors) > 0

    @property
    def has_warnings(self) -> bool:
        return len(self.warnings) > 0

    def add_error(self, error: CompilerError):
        self.errors.append(error)
        # Si fuera FATAL podrías lanzar excepción aquí

    def add_warning(self, warning: CompilerError):
        self.warnings.append(warning)

    def report(
        self,
        error_code: ErrorCode,
        mensaje: str,
        linea: int,
        columna: int,
        token=None,
        contexto=None,
    ):
        error = CompilerError(
            error_codigo=error_code,
            mensaje=mensaje,
            linea=linea,
            columna=columna,
            token=token,
            contexto=contexto,
        )
        if error_code.nivel == NivelError.WARNING:
            self.add_warning(error)
        else:
            self.add_error(error)
