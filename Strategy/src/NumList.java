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

    public int len(){
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
