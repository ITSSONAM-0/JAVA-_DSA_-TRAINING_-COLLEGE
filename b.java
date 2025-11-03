import java.util.*;

public class b {
    public static int binarySearch(int numbers[], int key) {
        int start = 0, end = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // comparisons
            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = { 1, 2, 3, 9, 11, 13, 17, 25, 57, 90 };
        int key = 57;
        System.out.println("index for key is:" + binarySearch(numbers, key));
    }
}
