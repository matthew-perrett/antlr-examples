package com.gitlab.mattperrett.antlr.calculator;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {
    public static void main(String[] args) {
        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString("12/6\n"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);

        ParseTree tree = parser.prog();

        CalculatorVisitorImpl eval = new CalculatorVisitorImpl();

        System.out.println(eval.visit(tree));
    }
}
