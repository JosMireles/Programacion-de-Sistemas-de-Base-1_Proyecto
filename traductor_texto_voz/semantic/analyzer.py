from parser.ast_nodes import ClauseNode, PhraseNode, SentenceNode, TextNode
from errors.error_handler import ErrorHandler
from errors.error_types import ERRORES_SEMANTICOS


class SemanticAnalyzer:
    def __init__(self, error_handler: ErrorHandler):
        self.error_handler = error_handler

    def analyze(self, ast: TextNode | None) -> None:
        if ast is None:
            return
        for sentence in ast.sentences:
            self._check_sentence(sentence)

    def _check_sentence(self, sentence: SentenceNode) -> None:
        if not sentence.clause.phrases:
            self.error_handler.report(
                ERRORES_SEMANTICOS["EMPTY_PHRASE"],
                "La oración no contiene frases válidas",
                sentence.linea,
                sentence.columna,
            )
        for phrase in sentence.clause.phrases:
            self._check_phrase(phrase)

    def _check_phrase(self, phrase: PhraseNode) -> None:
        if not phrase.terms:
            self.error_handler.report(
                ERRORES_SEMANTICOS["EMPTY_PHRASE"],
                "La frase no contiene términos válidos",
                phrase.linea,
                phrase.columna,
            )
