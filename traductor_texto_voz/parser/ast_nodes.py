from dataclasses import dataclass, field, asdict
from typing import List, Union


@dataclass
class ASTNode:
    linea: int = 1
    columna: int = 1

    def to_dict(self):
        return asdict(self)


@dataclass
class WordNode(ASTNode):
    valor: str = ""


@dataclass
class NumberNode(ASTNode):
    valor: str = ""


TermNode = Union[WordNode, NumberNode]


@dataclass
class PhraseNode(ASTNode):
    terms: List[TermNode] = field(default_factory=list)


@dataclass
class ClauseNode(ASTNode):
    phrases: List[PhraseNode] = field(default_factory=list)
    conjunctions: List[str] = field(default_factory=list)


@dataclass
class SentenceNode(ASTNode):
    tipo: str = ""
    clause: ClauseNode = field(default_factory=ClauseNode)
    punctuation: str = ""
    raw_text: str = ""


@dataclass
class TextNode(ASTNode):
    sentences: List[SentenceNode] = field(default_factory=list)
