import java.util.* ;
import java.io.*; 

public class Solution {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0;
        if (n == 1) return nums.get(0);

        int prev2 = nums.get(0);                        // dp[i-2]
        int prev1 = Math.max(nums.get(0), nums.get(1)); // dp[i-1]

        for (int i = 2; i < n; i++) {
            int take = nums.get(i) + prev2; // take current element
            int skip = prev1;               // skip current element
            int curr = Math.max(take, skip);

            // shift DP
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
