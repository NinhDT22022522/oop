

public class Demo {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[10];

        MyComparator comparatorBalanceAscending = new BalanceAscending();
        MyComparator comparatorBalanceDescending = new BalanceDescending();
        MyComparator comparatorTransactionCountDescending = new TransactionCountDescending();

        QuickSort quickSort = new QuickSort();

        accounts[0] = new BankAccount(10);
        accounts[1] = new BankAccount(5);
        accounts[2] = new BankAccount(90);
        accounts[2].deposit(10);
        accounts[3] = new BankAccount(60);
        accounts[3].deposit(5);
        accounts[4] = new BankAccount(40);
        accounts[5] = new BankAccount(70);
        accounts[6] = new BankAccount(30);
        accounts[7] = new BankAccount(80);
        accounts[8] = new BankAccount(35);
        accounts[9] = new BankAccount(75);

        //Balance Ascending
        quickSort.sort(accounts, comparatorBalanceAscending);
        for (int i = 0; i < 10; i++){
            System.out.println(accounts[i].getBalance());
        }

        //Balance Descending
        quickSort.sort(accounts, comparatorBalanceDescending);
        for (int i = 0; i < 10; i++){
            System.out.println(accounts[i].getBalance());
        }

        //Transaction Count Descending
        quickSort.sort(accounts, comparatorTransactionCountDescending);
        for (int i = 0; i < 10; i++){
            System.out.println(accounts[i].getTransactions());
        }
    }
}