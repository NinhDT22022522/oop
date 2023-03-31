package main;

public class Numeral implements Expression {
    private int value;
    public Numeral(int _value){
        value = _value;
    }


    public String convertToString() {
        return String.valueOf(value);
    }


    public int evaluate() {
        return value;
    }


}
