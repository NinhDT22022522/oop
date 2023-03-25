package main;

abstract public class BinaryExpression extends Expression {
    abstract public Expression left();
    abstract public Expression right();


    @Override
    abstract public String toString();

    @Override
    abstract public int evaluate();
}
