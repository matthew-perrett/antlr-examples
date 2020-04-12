grammar Calculator;
import CalculatorLexerRules;

prog:   stat+ ;

stat:   expr NEWLINE            # printExpr
    |   ID '=' expr NEWLINE     # assign
    |   NEWLINE                 # blank
    ;

expr:   expr ('*'|'/') expr     # MulDiv
    |   expr ('+'|'-') expr     # AddSub
    |   INT                     # init
    |   ID                      # id
    |   '(' expr ')'            # parens
    ;
