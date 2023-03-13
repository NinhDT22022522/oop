import java.util.Scanner;

public class RandomWalk {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;
        int cnt = 0;
        int cnt1 = 0, cnt2 = 0;

        while (Math.abs(x) < n && Math.abs(y) < n) {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x, y, 0.45);
            if (cnt % 2 == 0){
                if (cnt1 < cnt + 1){
                    x--;
                    cnt1++;
                }else if (cnt2 < cnt + 1){
                    y--;
                    cnt2++;
                }else {
                    cnt1 = 0;
                    cnt2 = 0;
                    cnt++;
                }
            }
            else {
                if (cnt1 < cnt + 1){
                    x++;
                    cnt1++;
                }else if (cnt2 < cnt + 1){
                    y++;
                    cnt2++;
                }else {
                    cnt1 = 0;
                    cnt2 = 0;
                    cnt++;
                }
            }
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledSquare(x, y, 0.45);
            StdDraw.show();
            StdDraw.pause(40);
        }
        StdOut.println("Total steps = " + steps);
    }
}