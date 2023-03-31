package main;

public interface BinaryExpression extends Expression {
    Expression getLeft();
    Expression getRight();
    String getOperator();
    default String convertToString(){
        return "(" + getLeft().convertToString() + " " + getOperator() + " " + getRight().convertToString() + ")";
    }
}
