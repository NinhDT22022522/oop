import java.util.Arrays;

import static java.util.Arrays.toString;

public class Main {
    public static void main(String[] args) {
        double[] listNum = {2, 4, 5, 6, 3, 1};
        SortAlgo quickSort = new QuickSort();
        NumList numList1 = new NumList(quickSort,listNum);
        System.out.println(Arrays.toString(numList1.getNumList()));
        numList1.setQuickSort();
        numList1.setOrder();
        System.out.println(Arrays.toString(numList1.getNumList()));
        numList1.setBubbleSort();
        numList1.setOrder();
        System.out.println(Arrays.toString(numList1.getNumList()));
    }
}