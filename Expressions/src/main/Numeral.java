package main;

import main.Expression;

public class Numeral implements Expression {
    private int value;
    public Numeral(int _value){
        value = _value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int evaluate() {
        return value;
    }


}
