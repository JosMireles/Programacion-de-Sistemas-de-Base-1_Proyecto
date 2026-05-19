from __future__ import annotations

import argparse
from pathlib import Path

from errors.error_handler import ErrorHandler
from errors.error_reporter import ErrorReporter
from lexer.Scanner import Scanner
from parser.parser import ParserWrapper
from semantic.analyzer import SemanticAnalyzer
from tts.tts_engine import TTSEngine
from utils.serializers import ast_to_json, ast_to_pretty_text, tokens_to_text, write_text


BASE_DIR = Path(__file__).resolve().parent


def process_text(texto: str, source_name: str = "entrada", output_dir: Path | None = None, speak: bool = True) -> int:
    error_handler = ErrorHandler()
    scanner = Scanner(texto, error_handler)
    tokens = scanner.escanear()

    parser = ParserWrapper(error_handler)
    ast = parser.parse_tokens(texto, tokens)

    semantic = SemanticAnalyzer(error_handler)
    semantic.analyze(ast)

    if output_dir is not None:
        write_text(output_dir / f"{source_name}_tokens.txt", tokens_to_text(tokens))
        write_text(output_dir / f"{source_name}_ast.txt", ast_to_pretty_text(ast))
        write_text(output_dir / f"{source_name}_ast.json", ast_to_json(ast))
        if error_handler.has_errors or error_handler.has_warnings:
            lines = ["ERRORES Y ADVERTENCIAS"]
            lines.extend(str(e) for e in error_handler.errors)
            lines.extend(str(w) for w in error_handler.warnings)
            write_text(output_dir / f"{source_name}_errores.txt", "\n".join(lines))
        else:
            status = "Entrada válida. Lista para TTS."
            write_text(output_dir / f"{source_name}_resultado.txt", status)

    print("\n=== ANÁLISIS LÉXICO ===")
    print(f"Tokens generados: {len(tokens)}")
    print("\n=== ANÁLISIS SINTÁCTICO ===")
    print("AST construido." if ast is not None else "AST no construido.")
    print("\n=== ANÁLISIS SEMÁNTICO ===")
    print("Sin errores semánticos." if not error_handler.has_errors else "Se detectaron errores.")

    if error_handler.has_errors:
        ErrorReporter.print_errors(error_handler.errors, error_handler.warnings)
        print("\n❌ La entrada NO cumple la gramática.")
        return 1

    print("\n✅ Entrada válida.")
    if speak:
        print("🔊 Reproduciendo voz...")
        TTSEngine(enabled=True).speak(texto)
    return 0


def interactive_mode(args: argparse.Namespace) -> int:
    print("=== Traductor de texto a voz (Analizador Léxico-Sintáctico) ===")
    print("Gramática: EaV2")
    print("Escribe 'salir' para terminar.\n")
    if args.tts:
        print("Modo voz activado: cuando la entrada sea válida, se leerá en voz alta.\n")
    while True:
        try:
            entrada = input("Ingresa una frase: ")
        except EOFError:
            break
        if entrada.strip().lower() == "salir":
            print("Saliendo...")
            break
        if not entrada.strip():
            continue
        process_text(entrada, "interactivo", args.output_dir, args.tts)
    return 0


def build_arg_parser() -> argparse.ArgumentParser:
    parser = argparse.ArgumentParser(description="Analizador léxico-sintáctico de texto a voz basado en EaV2.")
    parser.add_argument("input", nargs="?", help="Archivo .txt de entrada")
    parser.add_argument(
        "--tts",
        dest="tts",
        action="store_true",
        default=True,
        help="Activa la lectura en voz. Está activada por defecto.",
    )
    parser.add_argument(
        "--no-tts",
        dest="tts",
        action="store_false",
        help="Desactiva la lectura en voz.",
    )
    parser.add_argument("--interactive", action="store_true", help="Ejecuta en modo interactivo")
    parser.add_argument(
        "--output-dir",
        default=str(BASE_DIR / "outputs"),
        help="Directorio donde se guardarán tokens, AST y reportes",
    )
    return parser


def main() -> int:
    parser = build_arg_parser()
    args = parser.parse_args()
    args.output_dir = Path(args.output_dir)
    if args.interactive or not args.input:
        return interactive_mode(args)
    input_path = Path(args.input)
    texto = input_path.read_text(encoding="utf-8")
    return process_text(texto, input_path.stem, args.output_dir, args.tts)


if __name__ == "__main__":
    raise SystemExit(main())
