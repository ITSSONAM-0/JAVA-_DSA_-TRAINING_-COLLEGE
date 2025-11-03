public class MergeSort {

    // Main function that sorts arr[low...high]
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            // Sort first half
            mergeSort(arr, low, mid);

            // Sort second half
            mergeSort(arr, mid + 1, high);

            // Merge the two halves
            merge(arr, low, mid, high);
        }
    }

    // Merge two sorted halves
    private static void merge(int[] arr, int low, int mid, int high) {
        // Sizes of two subarrays
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // Temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data
        for (int i = 0; i < n1; i++)
            left[i] = arr[low + i];
        for (int j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];

        // Merge temp arrays back into arr
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[]
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[]
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
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
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Before Sorting:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("After Sorting:");
        printArray(arr);
    }
}
