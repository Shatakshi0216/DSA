import java.util.ArrayList;

public class Solution {
    
    public static int binarySearch(ArrayList<Integer> arr, int l, int r, int k) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) == k) return mid;
            else if (arr.get(mid) < k) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public static int search(ArrayList<Integer> arr, int n, int k) {
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) == k) return mid;

            // Left half is sorted
            if (arr.get(left) <= arr.get(mid)) {
                if (arr.get(left) <= k && k < arr.get(mid)) {
                    return binarySearch(arr, left, mid - 1, k);
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (arr.get(mid) < k && k <= arr.get(right)) {
                    return binarySearch(arr, mid + 1, right, k);
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // not found
    }
}
