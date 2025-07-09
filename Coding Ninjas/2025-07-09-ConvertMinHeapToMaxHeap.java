public class Solution {

    // Heapify function to maintain max-heap property at index i
    private static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Compare with left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Compare with right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not the current node
        if (largest != i) {
            // Swap current with largest
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            maxHeapify(arr, n, largest);
        }
    }

    // Your required function
    public static int[] MinToMaxHeap(int n, int[] arr) {
        // Start from last non-leaf node and move to root
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
        return arr;
    }
}
