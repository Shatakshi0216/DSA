import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int magicIndex(ArrayList<Integer> a, int n) {
        return findMagicIndex(a, 0, n - 1);
    }

    private static int findMagicIndex(ArrayList<Integer> a, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        int midVal = a.get(mid);

        if (midVal == mid) return mid;

        // Search left side
        int leftIndex = Math.min(mid - 1, midVal);
        int left = findMagicIndex(a, low, leftIndex);
        if (left != -1) return left;

        // Search right side
        int rightIndex = Math.max(mid + 1, midVal);
        return findMagicIndex(a, rightIndex, high);
    }
}
