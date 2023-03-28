public class QuickSort {
    public void sort(BankAccount[] accounts, MyComparator compare) {
        quickSort(accounts, 0, accounts.length - 1, compare);
    }

    private void quickSort(BankAccount[] accounts, int low, int high, MyComparator compare) {
        if (low < high) {
            int partitionIndex = partition(accounts, low, high, compare);

            quickSort(accounts, low, partitionIndex - 1, compare);
            quickSort(accounts, partitionIndex + 1, high, compare);
        }
    }

    private int partition(BankAccount[] accounts, int low, int high, MyComparator compare) {
        BankAccount pivot = accounts[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare.less(accounts[j], pivot)) {
                i++;
                swap(accounts, i, j);
            }
        }
        swap(accounts, i + 1, high);
        return i + 1;
    }

    private void swap(BankAccount[] accounts, int i, int j) {
        BankAccount temp = accounts[i];
        accounts[i] = accounts[j];
        accounts[j] = temp;
    }
}