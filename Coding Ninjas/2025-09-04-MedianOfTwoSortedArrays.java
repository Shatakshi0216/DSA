public class Solution {
    public static double median(int[] a, int[] b) {
        // Ensure a is the smaller array
        if (a.length > b.length) {
            return median(b, a);
        }

        int n = a.length, m = b.length;
        int total = n + m;
        int half = (total + 1) / 2;

        int left = 0, right = n;

        while (left <= right) {
            int i = (left + right) / 2;   // partition in a
            int j = half - i;             // partition in b

            // Handle boundaries
            int leftA = (i > 0) ? a[i - 1] : Integer.MIN_VALUE;
            int rightA = (i < n) ? a[i] : Integer.MAX_VALUE;

            int leftB = (j > 0) ? b[j - 1] : Integer.MIN_VALUE;
            int rightB = (j < m) ? b[j] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if (total % 2 == 0) {
                    // Even total length
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                } else {
                    // Odd total length
                    return Math.max(leftA, leftB);
                }
            } else if (leftA > rightB) {
                right = i - 1; // move partition left
            } else {
                left = i + 1;  // move partition right
            }
        }

        return 0.0; // Should never reach here
    }
}
