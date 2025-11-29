public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[][] dp = new int[n][maxWeight + 1];

        // Base case for the first item
        for(int w = 0; w <= maxWeight; w++){
            if(weight[0] <= w){
                dp[0][w] = value[0];
            }
        }

        // Fill DP table
        for(int i = 1; i < n; i++){
            for(int w = 0; w <= maxWeight; w++){
                int notTake = dp[i-1][w];
                int take = 0;

                if(weight[i] <= w){
                    take = value[i] + dp[i-1][w - weight[i]];
                }

                dp[i][w] = Math.max(take, notTake);
            }
        }

        return dp[n-1][maxWeight];
    }
}
