package main;

abstract public class BankAccount{
    private double balance;
    private int transactions;
    public BankAccount(double initialBalance){
        balance = initialBalance;
        transactions = 0;
    }
    public void deposit(double amount){
        balance += amount;
        transactions++;
    }
    public void withdraw(double amount){
        balance -= amount;
        transactions++;
    }
    abstract public void endMonthCharge();
    public void endMonth(){
        endMonthCharge();
        System.out.println("Balance: " + balance);
        System.out.println("Transactions: " + transactions);
        transactions = 0;
    }
}