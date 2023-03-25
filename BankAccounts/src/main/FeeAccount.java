package main;

public class FeeAccount extends BankAccount {
    public FeeAccount(double initialBalance){
        super(initialBalance);
    }
    public void endMonthCharge(){
        withdraw(5.0);
    }

    public static void main(String[] args) {
        FeeAccount one = new FeeAccount(100);
        one.deposit(10);
        one.deposit(10);
        one.deposit(10);
        one.withdraw(5);
        one.withdraw(5);
        one.withdraw(5);
        one.withdraw(5);
        one.endMonth();
    }
}