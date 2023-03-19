import java.util.*;

/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/

public class Shape {
    private List<Point> listPoint;

    public Shape(String str){
        Scanner scanner = new Scanner(str);
        List<Point> inp = new ArrayList<>();
        while(scanner.hasNext()){
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            Point newPoint = new Point(x, y);
            inp.add(newPoint);
        }
        this.listPoint = inp;
    }

    private Point center(){
        double sumX = 0;
        double sumY = 0;
        int sz = this.listPoint.size();
        for (Point point : this.listPoint) {
            sumX += point.getX();
            sumY += point.getY();
        }
        return new Point(sumX / sz, sumY / sz);
    }

    private double radious(){
        double radious = Double.MAX_VALUE;
        for (Point point : this.listPoint) {
            radious = Math.min(radious, this.center().distance(point));
        }
        return radious;
    }

    public boolean crosses(Shape other){
        int sz = listPoint.size();
        for (int i = 0; i < sz - 1; i++){
            double minDis = Math.min(listPoint.get(i).distance(other.center()), listPoint.get(i + 1).distance(other.center()));
            double maxDis = Math.max(listPoint.get(i).distance(other.center()), listPoint.get(i + 1).distance(other.center()));
            if (minDis < other.radious() && maxDis > other.radious()){
                return true;
            }
        }
        double minDis = Math.min(listPoint.get(0).distance(other.center()), listPoint.get(sz - 1).distance(other.center()));
        double maxDis = Math.max(listPoint.get(0).distance(other.center()), listPoint.get(sz - 1).distance(other.center()));
        if (minDis < other.radious() && maxDis > other.radious()){
            return true;
        }
        return false;
    }

    public int encircles(Shape other){
        double distanceOfCenter= this.center().distance(other.center());
        if (distanceOfCenter < this.radious()){
            return 2;
        }else if (this.radious() + other.radious() > distanceOfCenter){
            return 1;
        }else return 0;
    }
}

