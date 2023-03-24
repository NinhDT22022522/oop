public class NicklenDimeAccount extends BankAccount{
    private int withdrawCount;
    public NicklenDimeAccount(double initialBalance){
        super(initialBalance);
        withdrawCount = 0;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        withdrawCount++;
    }

    public void endMonthCharge(){
        withdraw(0.5 * withdrawCount);
        withdrawCount = 0;
    }

    public static void main(String[] args) {
        NicklenDimeAccount two = new NicklenDimeAccount(100);
        two.deposit(10);
        two.deposit(20);
        two.withdraw(5);
        two.withdraw(5);
        two.withdraw(5);
        two.withdraw(5);
        two.withdraw(5);
        two.withdraw(5);
        two.withdraw(5);
        two.withdraw(5);
        two.withdraw(5);
        two.withdraw(5);
        two.endMonth();
    }
}
