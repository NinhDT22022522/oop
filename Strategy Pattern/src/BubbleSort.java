public class BubbleSort implements SortAlgo{
    @Override
    public void sort(NumList numList) {
        double[] numbers = numList.getNumList();
        int len = numbers.length;
        for (int i = 0; i < len; i++){
            for (int j = 0 ; j < len - i - 1; j++){
                if (numbers[j] > numbers[j + 1]){
                    double tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }
    }
}
