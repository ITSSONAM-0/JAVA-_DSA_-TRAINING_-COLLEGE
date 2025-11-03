import java.util.*;

class CircularLinkedListt {
    public static void main(String[] args) {
        int size = 5;
        int arr[] = new int[size];
        int r = -1, f = 0, te = 0, n, x, choice;
        Scanner obj = new Scanner(System.in);
        for (;;) {
            System.out.println("1 Addition\n 2 Remove\n 3 Display\n 4 Exit");
            System.out.println("Enter chioce:");
            choice = obj.nextInt();
            switch (choice) {
                case 1:
                    if (te == size) {
                        System.out.println("Queue is full");
                    } else {
                        System.out.println("enter number");
                        n = obj.nextInt();
                        r = (r + 1) % size;
                        arr[r] = n;
                        te = te + 1;
                    }
                    break;

                case 2:
                    if (te == 0) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("number deleted" + arr[f]);
                        f = (f + 1) % size;
                        te = te - 1;
                    }
                    break;
                case 3:
                    if (te == 0) {
                        System.out.println("queue is empty");
                    } else {
                        x = f;
                        for (int i = 1; i <= te; i++) {
                            System.out.println(arr[i] + " ");
                            x = (x + 1) % size;
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("invalid");
            }

        }
    }
}