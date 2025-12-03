from dataclasses import dataclass, field
from typing import List

@dataclass
class ASTNode:
    pass

@dataclass
class TextNode(ASTNode):
    sentences: List["SentenceNode"] = field(default_factory=list)

@dataclass
class SentenceNode(ASTNode):
    tipo: str  # 'question', 'exclamation', 'declarative'
    contenido: List[ASTNode] = field(default_factory=list)

@dataclass
class WordNode(ASTNode):
    valor: str

@dataclass
class NumberNode(ASTNode):
    valor: str
