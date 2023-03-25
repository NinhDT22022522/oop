package main;

public class Square extends Expression {
    private Expression expression;
    public Square(Expression _expression){
        expression = _expression;
    }

    @Override
    public String toString() {
        return expression + "^2";
    }

    @Override
    public int evaluate() {
        return expression.evaluate() * expression.evaluate();
    }

    public static void main(String[] args) {
        Expression one = new Numeral(2);
        Expression two = new Square(one);
        System.out.println(two.toString());
        System.out.println(two.evaluate());
    }
}
