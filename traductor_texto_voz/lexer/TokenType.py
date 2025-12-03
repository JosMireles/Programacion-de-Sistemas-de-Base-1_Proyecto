from enum import Enum, auto

class TokenType(Enum):
    # Tokens léxicos básicos
    WORD = auto()       # Palabras normales
    NUMBER = auto()     # Números
    PUNCT = auto()      # Puntuación: . , : ;
    LEXCL = auto()      # ¡
    REXCL = auto()      # !
    LQN = auto()        # ¿
    RQN = auto()        # ?
    LPAREN = auto()     # (
    RPAREN = auto()     # )
    CONJ = auto()       # y, o, pero

    EOF = auto()        # Fin de archivo / entrada
