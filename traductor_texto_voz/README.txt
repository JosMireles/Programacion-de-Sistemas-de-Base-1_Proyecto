Proyecto: Traductor de texto a voz (Analizador léxico-sintáctico)
Gramática: EaV2

Estructura sugerida por el profesor:
- grammar/ -> especificación formal (EaV2.g4)
- lexer/ y parser/ -> código fuente del analizador
- semantic/ -> validaciones adicionales
- tests/ -> entradas válidas e inválidas
- outputs/ -> archivos de salida del traductor
- docs/ -> reporte PDF final
- examples/ -> ejemplo rápido de ejecución

Ejecución rápida con voz:
1) Instalar dependencias
   pip install -r requirements.txt

2) Ejecutar en modo interactivo con voz activada por defecto
   python main.py --interactive

3) Escribir una frase válida, por ejemplo:
   Hola mundo.
   ¿Como estas?
   ¡Buenos dias!

4) Para desactivar la voz manualmente
   python main.py --interactive --no-tts

5) Probar una entrada concreta desde archivo
   python main.py examples/entrada_demo.txt

6) Ejecutar batería de pruebas
   python tests/test_runner.py

Nota importante sobre TTS:
- La voz usa pyttsx3 y la voz instalada en Windows.
- Si no se escucha nada, instala o reinstala la dependencia:
  pip install -r requirements.txt
- El proyecto intenta seleccionar automáticamente una voz en español si existe en el sistema.

Archivos de salida generados por el proyecto:
- *_tokens.txt
- *_ast.txt
- *_ast.json
- *_resultado.txt o *_errores.txt
