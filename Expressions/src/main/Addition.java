package main;

public class Addition implements BinaryExpression {
    private Expression left, right;
    public Addition(Expression _left, Expression _right){
        left = _left;
        right = _right;
    }


    public Expression getLeft() {
        return left;
    }


    public Expression getRight() {
        return right;
    }

    @Override
    public String getOperator() {
        return "+";
    }


    @Override
    public int evaluate() {
        return left.evaluate()  + right.evaluate();
    }


    public static void main(String[] args) {
        Expression two = new Numeral(2);
        Expression twoSquare = new Square(two);
        Expression twoPlusTwoSquare = new Addition(two, twoSquare);
        System.out.println(twoPlusTwoSquare.convertToString());
        System.out.println(twoPlusTwoSquare.evaluate());
    }
}
