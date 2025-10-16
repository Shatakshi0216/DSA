import java.util.*;
import java.io.*;

public class Solution {

    public static long getInversions(long arr[], int n) {
        return mergeSort(arr, 0, n - 1);
    }

    private static long mergeSort(long[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left half
            count += mergeSort(arr, left, mid);

            // Count inversions in right half
            count += mergeSort(arr, mid + 1, right);

            // Count inversions while merging
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    private static long merge(long[] arr, int left, int mid, int right) {
        long[] temp = new long[right - left + 1];
        int i = left;      // left half pointer
        int j = mid + 1;   // right half pointer
        int k = 0;         // temp array pointer
        long inversions = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // arr[i] > arr[j] ? all remaining elements in left half are greater
                inversions += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // Copy back to original array
        System.arraycopy(temp, 0, arr, left, temp.length);

        return inversions;
    }
}
