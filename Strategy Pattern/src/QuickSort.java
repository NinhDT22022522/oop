public class QuickSort implements SortAlgo {
    @Override
    public void sort(NumList numList) {
        double[] numbers = numList.getNumList();
        int len = numList.len();
        quicksort(numbers, 0, len - 1);
    }

    private int partition(double[] arrays, int low, int high){
        double pivot = arrays[high];
        int i = low - 1;
        for (int j = low; j < high; j++){
            if (arrays[j] < pivot){
                i = i + 1;
                swap(arrays, i, j);
            }
        }
        swap(arrays, i + 1, high);
        return i + 1;
    }
    private void swap(double[] arrays,int i, int j){
        double tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }
    private void quicksort(double[] arrays, int low, int high){
        if (low < high){
            int pivotIndex = partition(arrays, low, high);
            quicksort(arrays, low, pivotIndex - 1);
            quicksort(arrays, pivotIndex + 1, high);
        }
    }

}
