from typing import List
from .error_types import CompilerError

class ErrorReporter:
    @staticmethod
    def print_errors(errors: List[CompilerError], warnings: List[CompilerError], show_warnings: bool = True):
        if errors:
            print("\n=== ERRORES ===")
            for e in errors:
                print(e)
        if show_warnings and warnings:
            print("\n=== ADVERTENCIAS ===")
            for w in warnings:
                print(w)
