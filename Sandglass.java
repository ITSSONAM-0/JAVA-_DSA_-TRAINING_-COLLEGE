import java.util.*;

public class Sandglass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Top Half
        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }

        // Bottom Half
        for (int i = 2; i <= n; i++) {
            for (int j = n; j > i; j--)
                System.out.print(" ");
            for (int j = 1; j <= (2 * i - 1); j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
