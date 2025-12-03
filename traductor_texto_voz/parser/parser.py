from antlr4 import CommonTokenStream, InputStream, RecognitionException, ErrorListener
from EaV2Lexer import EaV2Lexer
from EaV2Parser import EaV2Parser
from errors.error_handler import ErrorHandler
from errors.error_types import ERRORES_SINTACTICOS

class SintaxErrorListener(ErrorListener.ErrorListener):
    def __init__(self, error_handler: ErrorHandler):
        super().__init__()
        self.error_handler = error_handler

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e: RecognitionException):
        error_code = ERRORES_SINTACTICOS["UNEXPECTED_TOKEN"]
        self.error_handler.report(
            error_code=error_code,
            mensaje=msg,
            linea=line,
            columna=column,
            token=offendingSymbol,
        )

class ParserWrapper:
    def __init__(self, error_handler: ErrorHandler):
        self.error_handler = error_handler

    def parse(self, texto: str):
        input_stream = InputStream(texto)
        lexer = EaV2Lexer(input_stream)
        token_stream = CommonTokenStream(lexer)
        parser = EaV2Parser(token_stream)

        parser.removeErrorListeners()
        parser.addErrorListener(SintaxErrorListener(self.error_handler))

        tree = parser.text()
        return tree
