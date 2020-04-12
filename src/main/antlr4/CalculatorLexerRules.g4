lexer grammar CalculatorLexerRules;

MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
ID  :   [a-zA-Z]+ ;
INT :   [0-9]+ ;
NEWLINE: '\r'? '\n' ;
WS  :   [ \t]+ -> skip ;

