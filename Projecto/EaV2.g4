grammar EaV2;

// ======= Regla inicial =======
text : sentence+ EOF ;

sentence : question | exclamation | declarative ;

question       : questionStrict | questionLoose ;
questionStrict : LQN clause RQN ;
questionLoose  : clause RQN ;

exclamation : exclamationStrict | exclamationLoose ;
exclamationStrict : LEXCL clause REXCL ;
exclamationLoose :clause REXCL ;

declarative : clause PUNCT? ;

clause : phrase (CONJ phrase)* ;

phrase : term+ ;

term : WORD | NUMBER ;

// ======= Lexer =======
LEXCL   : '¡' ;
REXCL   : '!' ;
LQN     : '¿' ;
RQN     : '?' ;
PUNCT   : [.,:;] ;
CONJ    : 'y' | 'o' | 'pero' ;
NUMBER  : [0-9]+ ;
WORD    : [a-zA-ZáéíóúÁÉÍÓÚñÑ]+ ;
WS      : [ \t\r\n]+ -> skip ;