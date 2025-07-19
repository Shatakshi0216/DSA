import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        k = k % n;  // Handle if k > n

        // Step 1: Reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 2: Reverse remaining n-k elements
        reverse(arr, k, n - 1);

        // Step 3: Reverse the whole array
        reverse(arr, 0, n - 1);

        return arr;
    }

    // Helper function to reverse elements in ArrayList from 'start' to 'end'
    private static void reverse(ArrayList<Integer> arr, int start, int end) {
        while (start < end) {
            // Swap elements at start and end
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }
}
