

import java.util.Random;
import java.util.Scanner;

public class Bugs {
    private static final Random random = new Random();
    public static class Bug{
        private int x;
        private int y;
        private char symbol;

        public Bug(int x, int y, char symbol){
            this.symbol = symbol;
            this.x = x;
            this.y = y;
        }

        public char getSymbol() {
            return symbol;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void move(int W, int H){
            int direction = random.nextInt(2);
            if (direction == 0){
                int dx = random.nextInt(2);
                if (dx == 0){
                    if (x < H - 1){
                        x += 1;
                    }
                }else{
                    if (x > 0) x -= 1;
                }
            }else{
                int dy = random.nextInt(2);
                if (dy == 0){
                    if (y < W - 1){
                        y += 1;
                    }
                }else{
                    if (y > 0) y -= 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int H = scanner.nextInt();
        int W = scanner.nextInt();

        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(W, H);

        Bug[] bugs = new Bug[N];
        for (int i = 0; i < N; i++){
            bugs[i] = new Bug(random.nextInt(H), random.nextInt(W), (char) ('A' + i % 26));
            graphics.drawPoint(bugs[i].getSymbol(), bugs[i].getX(), bugs[i].getY());
        }

        graphics.render();;

        while (true){
            graphics.clear();
            for (Bug bug : bugs){
                bug.move(W, H);
                graphics.drawPoint(bug.getSymbol(), bug.getX(), bug.getY());
            }
            graphics.render();
            try { Thread.sleep(1000);} catch (InterruptedException e){}
        }
    }

}
