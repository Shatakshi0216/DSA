import java.util.ArrayList;

public class Solution
{
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
    {
        int n = matrix.size();
        int m = matrix.get(0).size();
        int desired = (n * m) / 2; // zero-based index of median when flattened (since n*m is odd)

        // find global min and max from matrix (rows are sorted)
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (ArrayList<Integer> row : matrix) {
            if (!row.isEmpty()) {
                minVal = Math.min(minVal, row.get(0));
                maxVal = Math.max(maxVal, row.get(row.size() - 1));
            }
        }

        int low = minVal;
        int high = maxVal;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // count of elements <= mid
            int count = 0;
            for (ArrayList<Integer> row : matrix) {
                count += upperBound(row, mid);
            }

            // if count <= desired, median is greater than mid
            if (count <= desired) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    // returns number of elements <= target in a sorted ArrayList<Integer>
    private static int upperBound(ArrayList<Integer> row, int target) {
        int l = 0, r = row.size(); // r is exclusive
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (row.get(mid) <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
