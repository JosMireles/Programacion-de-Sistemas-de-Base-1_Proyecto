from typing import Iterable


class ErrorReporter:
    @staticmethod
    def print_errors(errors: Iterable, warnings: Iterable, show_warnings: bool = True) -> None:
        if errors:
            print("\n=== ERRORES ===")
            for e in errors:
                print(e)
        if show_warnings and warnings:
            print("\n=== ADVERTENCIAS ===")
            for w in warnings:
                print(w)
