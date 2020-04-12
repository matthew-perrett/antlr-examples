package com.gitlab.mattperrett.antlr.calculator;


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calculator {
    public static void main(String[] args) throws Exception {
        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString("1 + 4\n"));
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        CalculatorParser parser = new CalculatorParser(tokens);
//
//        ParseTree tree = parser.prog();
//
//        System.out.println(tree.toStringTree(parser)); // print tree as text <label id="code.tour.main.7"/>
    }
}
