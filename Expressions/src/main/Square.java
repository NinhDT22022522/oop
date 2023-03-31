package main;

public class Square implements Expression {
    private Expression expression;
    public Square(Expression _expression){
        expression = _expression;
    }

    @Override
    public String convertToString() {
        return expression.convertToString()+ "^2";
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
