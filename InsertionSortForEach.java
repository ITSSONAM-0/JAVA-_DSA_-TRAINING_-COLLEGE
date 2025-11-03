public class InsertionSortForEach {

    public static void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int arr[]) {
        for (int num : arr) { // for-each loop
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 9, 5, 1, 4, 3 };

        System.out.println("Before Sorting:");
        printArray(arr);
        insertionSort(arr);
        System.out.println("After Sorting:");
        printArray(arr);
    }
}
