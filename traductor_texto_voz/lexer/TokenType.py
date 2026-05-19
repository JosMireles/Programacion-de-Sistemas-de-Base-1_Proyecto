from enum import Enum, auto


class TokenType(Enum):
    WORD = auto()
    NUMBER = auto()
    PUNCT = auto()
    LEXCL = auto()
    REXCL = auto()
    LQN = auto()
    RQN = auto()
    CONJ = auto()
    EOF = auto()
