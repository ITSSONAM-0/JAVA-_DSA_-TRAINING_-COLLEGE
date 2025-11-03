public class QuickSort {

    // Partition function
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // last element pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot into correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // QuickSort function
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // recursive calls
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Main function
    public static void main(String args[]) {
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        System.out.println("Before Sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, n - 1);

        System.out.println("\nAfter Sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
