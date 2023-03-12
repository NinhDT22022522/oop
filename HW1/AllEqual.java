import java.util.Scanner;

public class AllEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (a == b && b == c){
            System.out.println("equal");
        }else System.out.println("not equal");
    }
}
