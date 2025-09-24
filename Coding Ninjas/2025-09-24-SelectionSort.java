public class Solution {
    public static void selectionSort(int[] arr) {
        int N = arr.length;
        
        // Traverse through all array elements
        for (int i = 0; i < N - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // For testing
    public static void main(String[] args) {
        int[] arr = {8, 6, 2, 5, 1};
        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
