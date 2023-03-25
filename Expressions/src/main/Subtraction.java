package main;

import main.BinaryExpression;
import main.Expression;

public class Subtraction extends BinaryExpression {
    private Expression left, right;
    public Subtraction(Expression _left, Expression _right){
        left = _left;
        right = _right;
    }

    @Override
    public Expression left() {
        return left;
    }

    @Override
    public Expression right() {
        return right;
    }

    @Override
    public String toString() {
        return "(" + left().toString() + " - " +  right().toString() + ")";
    }

    @Override
    public int evaluate() {
        return left().evaluate() - right().evaluate();
    }
}
