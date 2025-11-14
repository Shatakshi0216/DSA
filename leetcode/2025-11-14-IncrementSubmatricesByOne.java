class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // We use (n+1) x (n+1) for safe boundary handling
        int[][] diff = new int[n + 1][n + 1];

        // 1) Apply all queries in O(1) each (4 updates per query)
        for (int[] q : queries) {
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];

            diff[r1][c1] += 1;
            diff[r1][c2 + 1] -= 1;
            diff[r2 + 1][c1] -= 1;
            diff[r2 + 1][c2 + 1] += 1;
        }

        // 2) Prefix sum horizontally (row-wise)
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // 3) Prefix sum vertically (column-wise)
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        // 4) Build the answer matrix (ignore extra last row/col)
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(diff[i], 0, res[i], 0, n);
        }

        return res;
    }
}
