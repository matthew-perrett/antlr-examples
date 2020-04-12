package com.gitlab.mattperrett.antlr.calculator;

import java.util.HashMap;
import java.util.Map;

public class CalculatorVisitorImpl extends CalculatorBaseVisitor<Integer> {

    private Map<String, Integer> memory = new HashMap<>();

    @Override
    public Integer visitAssign(CalculatorParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Integer value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitPrintExpr(CalculatorParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        System.out.println(value);
        return value;
    }

    @Override
    public Integer visitInt(CalculatorParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitId(CalculatorParser.IdContext ctx) {
        String id = ctx.ID().getText();
        return memory.getOrDefault(id, 0);
    }

    @Override
    public Integer visitMulDiv(CalculatorParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if ( ctx.op.getType() == CalculatorParser.MUL ) {
            return left * right;
        } else {
            return left / right;
        }
    }

    @Override
    public Integer visitAddSub(CalculatorParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0));  // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == CalculatorParser.ADD ) {
            return left + right;
        } else {
            return left - right;
        }
    }

    @Override
    public Integer visitParens(CalculatorParser.ParensContext ctx) {
        return visit(ctx.expr());
    }
}
