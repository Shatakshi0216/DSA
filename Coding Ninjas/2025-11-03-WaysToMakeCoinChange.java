public class Solution {

    public static long countWaysToMakeChange(int denominations[], int value){
        long[] dp = new long[value + 1];
        dp[0] = 1;

        for(int coin : denominations){
            for(int j = coin; j <= value; j++){
                dp[j] += dp[j - coin];
            }
        }
        return dp[value];
    }
    
}
