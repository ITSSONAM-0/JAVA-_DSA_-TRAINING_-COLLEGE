public class SelectionSort {
    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // assume current index has minimum

            // Find the index of the smallest element in remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element of unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };

        System.out.println("Before Sorting:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("After Sorting:");
        printArray(arr);
    }
}
