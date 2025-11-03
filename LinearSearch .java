public class LinearSearch {
    public static int linearSearch(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i; // return index
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int x = 30;
        int result = linearSearch(arr, x);
        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + result);
    }
}
