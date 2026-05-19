from __future__ import annotations

import subprocess
import sys
from pathlib import Path

BASE_DIR = Path(__file__).resolve().parents[1]
MAIN = BASE_DIR / "main.py"


def run_case(path: Path) -> int:
    result = subprocess.run(
        [sys.executable, str(MAIN), str(path), "--output-dir", str(BASE_DIR / "outputs")],
        cwd=BASE_DIR,
        capture_output=True,
        text=True,
        encoding="utf-8",
    )
    print(f"\n--- {path.name} ---")
    print(result.stdout)
    if result.stderr:
        print("STDERR:")
        print(result.stderr)
    return result.returncode


if __name__ == "__main__":
    valid = sorted((BASE_DIR / "tests" / "valid").glob("*.txt"))
    invalid = sorted((BASE_DIR / "tests" / "invalid").glob("*.txt"))
    failures = 0
    for path in valid:
        if run_case(path) != 0:
            failures += 1
    for path in invalid:
        if run_case(path) == 0:
            failures += 1
    print(f"\nPruebas finalizadas. Fallos: {failures}")
    raise SystemExit(1 if failures else 0)
