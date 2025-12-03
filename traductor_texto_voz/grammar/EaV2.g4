grammar EaV2;

// ======= Regla inicial =======
text
    : sentence+ EOF
    ;

// ======= Reglas de parser =======

sentence
    : question
    | exclamation
    | declarative
    ;

// Pregunta: ¿cláusula?
question
    : LQN clause RQN
    ;

// Exclamación: (¡)? cláusula !
exclamation
    : LEXCL? clause REXCL
    ;

// Declarativa: cláusula con puntuación opcional
declarative
    : clause PUNCT?
    ;

// Cláusula con posibles conjunciones
clause
    : phrase (CONJ phrase)*
    ;

// Frase = secuencia de términos
phrase
    : term+
    ;

// Términos permitidos: palabra o número
term
    : WORD
    | NUMBER
    ;

// ======= Lexer =======

// Conjunciones
CONJ
    : 'y'
    | 'o'
    | 'pero'
    ;

// Números
NUMBER
    : [0-9]+
    ;

// Palabras (con tildes y ñ)
WORD
    : [a-zA-ZáéíóúÁÉÍÓÚñÑ]+
    ;

// Puntuación suave
PUNCT
    : [.,:;]
    ;

// Paréntesis
LPAREN  : '(' ;
RPAREN  : ')' ;

// Exclamación
LEXCL   : '¡' ;
REXCL   : '!' ;

// Interrogación
LQN     : '¿' ;
RQN     : '?' ;

// Espacios en blanco
WS
    : [ \t\r\n]+ -> skip
    ;
