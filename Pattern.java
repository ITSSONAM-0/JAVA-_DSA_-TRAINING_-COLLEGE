import java.util.*;

public class Pattern {

    public static void main(String[] args) {
        int i, j, n;
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter any number");
        n = obj.nextInt();

        for (i = 0; i < (n / 2) + 1; i++) {
            for (j = 0; j < n - i + (n / 2); j++) {
                System.out.print(" ");
            }
            for (j = 0; j < (2 * i) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (i = 0; i < (n / 2) + 1; i++) {
            for (j = 0; j < n * 2; j++) {
                if (j == n || j == (2 * n) - 1) {
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (i = 0; i < (n / 2) + 1; i++) {
            for (j = 0; j < n * 3; j++) {
                if (j >= i && j <= n - 1 - i || j >= 2 * n + i && j <= (n * 3) - 1 - i) {
                    System.out.print("*");
                } else if (i == 0 && j == n || i == 0 && j == 2 * n - 1) {
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}