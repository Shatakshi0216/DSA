import java.util.*;

public class Solution {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int[][] row : dp)
            for (int[] arr : row)
                Arrays.fill(arr, -1);
        return helper(0, 0, c - 1, grid, dp, r, c);
    }

    private static int helper(int i, int j1, int j2, int[][] grid, int[][][] dp, int r, int c) {
        // Out of bounds
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c)
            return (int) -1e8;

        // Base case (last row)
        if (i == r - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        // Memoization
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];

                value += helper(i + 1, j1 + dj1, j2 + dj2, grid, dp, r, c);
                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
}
