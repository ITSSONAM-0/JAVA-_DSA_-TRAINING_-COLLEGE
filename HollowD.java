import java.util.*;

public class HollowD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Top Half
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++)
                System.out.print(" ");
            System.out.print("*");
            if (i > 1) {
                for (int j = 1; j <= (2 * i - 3); j++)
                    System.out.print(" ");
                System.out.print("*");
            }
            System.out.println();
        }

        // Bottom Half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i; j < n; j++)
                System.out.print(" ");
            System.out.print("*");
            if (i > 1) {
                for (int j = 1; j <= (2 * i - 3); j++)
                    System.out.print(" ");
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
