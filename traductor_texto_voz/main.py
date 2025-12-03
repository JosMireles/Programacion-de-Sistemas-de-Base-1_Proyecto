from lexer.Scanner import Scanner
from errors.error_handler import ErrorHandler
from errors.error_reporter import ErrorReporter
from parser.parser import ParserWrapper
from tts.tts_engine import TTSEngine

def main():
    print("=== Traductor de texto a voz (Analizador Léxico-Sintáctico) ===")
    print("Gramática: EaV2")
    print("Escribe 'salir' para terminar.\n")

    tts = TTSEngine()

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

        # 1. Análisis léxico (wrapper de ANTLR)
        scanner = Scanner(entrada)
        tokens = scanner.escanear()
        # Aquí podrías imprimir tokens para depuración:
        # for tok in tokens: print(tok)

        # 2. Análisis sintáctico
        error_handler = ErrorHandler()
        parser = ParserWrapper(error_handler)
        _ = parser.parse(entrada)

        if error_handler.has_errors:
            ErrorReporter.print_errors(error_handler.errors, error_handler.warnings)
            print("❌ La frase NO cumple la gramática. No se enviará a TTS.\n")
            continue

        print("✅ Frase válida. Enviando a TTS...\n")
        tts.speak(entrada)

if __name__ == "__main__":
    main()
