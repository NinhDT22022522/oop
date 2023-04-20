public class NumList {
    private SortAlgo sortAlgo;
    private double[] listOfNum;

    public double[] getNumList(){
        return listOfNum;
    }

    public NumList(SortAlgo sortAlgo, double[] listOfNum) {
        this.sortAlgo = sortAlgo;
        this.listOfNum = listOfNum;
    }

    public int add(double number){
        double[] tmp = new double[listOfNum.length + 1];
        System.arraycopy(listOfNum, 0, tmp, 0, listOfNum.length);
        tmp[listOfNum.length] = number;
        listOfNum = tmp;
        return listOfNum.length;
    }
    public void setBubbleSort(){
        this.sortAlgo = new BubbleSort();
    }
    public void setQuickSort(){
        this.sortAlgo = new QuickSort();
    }
    public void setOrder(){
        sortAlgo.sort(this);
    }

}
