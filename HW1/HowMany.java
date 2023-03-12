import java.util.Scanner;

public class HowMany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // number of command-line arguments
        String in = scanner.nextLine();
        int n = in.length();

        // output message
        System.out.print("You entered " + n + " command-line argument");
        if (n == 1) System.out.println(".");
        else        System.out.println("s.");
    }
}
