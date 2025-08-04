import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
    /**
     * Reverses an ArrayList from the position m+1 to the end.
     *
     * @param arr The ArrayList of integers to be partially reversed.
     * @param m   The index after which the reversal should start. The element at index m is not moved.
     */
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        // Define the boundaries for the reversal.
        // The start index is the element right after m.
        int start = m + 1;
        // The end index is the last element of the list.
        int end = arr.size() - 1;

        // Use a two-pointer approach to swap elements from the start and end
        // of the sublist until the pointers meet or cross.
        while (start < end) {
            // Swap the elements at the start and end pointers.
            // A temporary variable holds one value during the swap.
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);

            // Move the pointers towards the center of the sublist.
            start++;
            end--;
        }
    }
}
