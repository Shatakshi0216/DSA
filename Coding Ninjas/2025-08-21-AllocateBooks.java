import java.util.*;

public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long low = 0, high = 0;
        
        // low = max(time[i]), high = sum(time[i])
        for (int t : time) {
            low = Math.max(low, t);
            high += t;
        }

        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canDistribute(time, n, mid)) {
                ans = mid; // possible answer
                high = mid - 1; // try smaller
            } else {
                low = mid + 1; // need more capacity
            }
        }

        return ans;
    }

    private static boolean canDistribute(int[] time, int days, long limit) {
        long sum = 0;
        int countDays = 1; // at least one day required

        for (int t : time) {
            if (sum + t <= limit) {
                sum += t; 
            } else {
                countDays++;
                sum = t;
                if (countDays > days) return false;
            }
        }
        return true;
    }
}
