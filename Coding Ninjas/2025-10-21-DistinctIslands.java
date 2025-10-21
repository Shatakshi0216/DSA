import java.util.*;

class Pair {
    int row, col;
    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

public class Solution {

    // BFS that returns the shape of the island
    public static String bfs(int[][] arr, int n, int m, int[][] visited, int i, int j, int[] r, int[] c) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        visited[i][j] = 1;

        StringBuilder shape = new StringBuilder();
        shape.append("0,0;"); // origin point

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;

            for (int k = 0; k < 4; k++) {
                int newRow = row + r[k];
                int newCol = col + c[k];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    visited[newRow][newCol] == 0 && arr[newRow][newCol] == 1) {

                    visited[newRow][newCol] = 1;
                    q.offer(new Pair(newRow, newCol));

                    // store relative position
                    shape.append((newRow - i) + "," + (newCol - j) + ";");
                }
            }
        }

        return shape.toString();
    }

    public static int distinctIsland(int[][] arr, int n, int m) {
        int[][] visited = new int[n][m];
        int[] r = {-1, 0, 1, 0};
        int[] c = {0, 1, 0, -1};
        HashSet<String> distinctShapes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && arr[i][j] == 1) {
                    String shape = bfs(arr, n, m, visited, i, j, r, c);
                    distinctShapes.add(shape);
                }
            }
        }

        return distinctShapes.size();
    }
}
