import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input to swap: ");
        System.out.print("First: ");
        int a = scanner.nextInt();
        System.out.print("Second: ");
        int b = scanner.nextInt();
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
        System.out.println("Result: ");
        System.out.println("First: " + a);
        System.out.println("Second: " + b);
    }
}
