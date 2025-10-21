class Pair {
    int row, col;
    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int count = 0;

        // 4 directions only (up, right, down, left)
        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid, visited, r, c, m, n);
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, char[][] grid, int[][] visited,
                     int[] r, int[] c, int m, int n) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;

            for (int k = 0; k < 4; k++) {
                int newRow = row + r[k];
                int newCol = col + c[k];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    visited[newRow][newCol] == 0 && grid[newRow][newCol] == '1') {

                    visited[newRow][newCol] = 1;
                    q.offer(new Pair(newRow, newCol));
                }
            }
        }
    }
}
