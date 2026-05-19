import json
from pathlib import Path
from typing import Iterable
from parser.ast_nodes import TextNode


def tokens_to_text(tokens: Iterable) -> str:
    lines = ["TIPO\tLEXEMA\tLINEA\tCOLUMNA"]
    for t in tokens:
        lines.append(f"{t.type.name}\t{t.lexema}\t{t.linea}\t{t.columna}")
    return "\n".join(lines)


def ast_to_json(ast: TextNode | None) -> str:
    if ast is None:
        return json.dumps({"ast": None}, ensure_ascii=False, indent=2)
    return json.dumps(ast.to_dict(), ensure_ascii=False, indent=2)


def ast_to_pretty_text(ast: TextNode | None) -> str:
    if ast is None:
        return "AST no generado."
    lines = ["text"]
    for i, sentence in enumerate(ast.sentences, start=1):
        lines.append(f"  sentence[{i}] tipo={sentence.tipo} punct='{sentence.punctuation}'")
        for j, phrase in enumerate(sentence.clause.phrases, start=1):
            terms = " ".join(getattr(term, 'valor', '') for term in phrase.terms)
            lines.append(f"    phrase[{j}] -> {terms}")
            if j <= len(sentence.clause.conjunctions):
                lines.append(f"      conj -> {sentence.clause.conjunctions[j-1]}")
    return "\n".join(lines)


def write_text(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(content, encoding="utf-8")
