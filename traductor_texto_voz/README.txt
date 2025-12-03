Proyecto: Traductor de texto a voz (Analizador léxico-sintáctico)
Gramática: EaV2 (ANTLR4)

PASOS RÁPIDOS:

1) Crear entorno virtual (opcional) e instalar dependencias:
   pip install -r requirements.txt

2) Generar lexer y parser de ANTLR:
   - Ir a la carpeta grammar:
        cd grammar
   - Ejecutar:
        antlr4 -Dlanguage=Python3 EaV2.g4
   - Copiar EaV2Lexer.py y EaV2Parser.py generados a la carpeta raíz del proyecto
     (donde está main.py), o ajustar los imports en scanner/parser para tu ruta.

3) Ejecutar el proyecto:
   python main.py

4) Prueba con frases como:
   Hola, ¿cómo estás?
   El número es 37
