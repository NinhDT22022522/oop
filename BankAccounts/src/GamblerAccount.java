import java.util.Random;

public class GamblerAccount extends BankAccount{
    private Random ran = new Random();
    private double charge;
    public GamblerAccount(double initialBalance){
        super(initialBalance);
        charge = 0;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        double pro = ran.nextDouble();
        if (pro >= .51) {
            charge += amount;
        }
    }

    @Override
    public void endMonthCharge() {
        withdraw(charge);
    }

    public static void main(String[] args) {
        GamblerAccount three = new GamblerAccount(200);
        three.deposit(10);
        three.deposit(20);
        three.withdraw(10);
        three.withdraw(10);
        three.endMonth();
    }
}
