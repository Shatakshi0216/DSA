import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = uncolored, 1 = red, -1 = blue

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue; // already colored in previous BFS

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 1; // start coloring this component

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int neighbour : graph[curr]) {
                    if (color[neighbour] == 0) {
                        color[neighbour] = -color[curr]; // alternate color
                        q.offer(neighbour);
                    } else if (color[neighbour] == color[curr]) {
                        // same color on both ends of an edge
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
