package main;

import main.BinaryExpression;
import main.Expression;

public class Multiplication implements BinaryExpression {
    private Expression left, right;
    public Multiplication(Expression _left, Expression _right){
        left = _left;
        right = _right;
    }

    @Override
    public Expression getLeft() {
        return left;
    }

    @Override
    public Expression getRight() {
        return right;
    }

    @Override
    public String getOperator() {
        return "*";
    }



    @Override
    public int evaluate() {
        return left.evaluate()* right.evaluate();
    }
}
