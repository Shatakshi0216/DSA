import java.util.*;

class Pair {
    int vertex;
    int parent;

    Pair(int v, int p) {
        vertex = v;
        parent = p;
    }
}

public class Solution {

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert edges matrix to adjacency list
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Visited array
        int visited[] = new int[n + 1];
        Arrays.fill(visited, 0);

        // Check every component (to handle disconnected graphs)
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                Queue<Pair> q = new LinkedList<>();
                q.offer(new Pair(i, -1));
                visited[i] = 1;

                while (!q.isEmpty()) {
                    Pair curr = q.poll();
                    int node = curr.vertex;
                    int parent = curr.parent;

                    for (int neighbour : adj.get(node)) {
                        if (visited[neighbour] == 0) {
                            visited[neighbour] = 1;
                            q.offer(new Pair(neighbour, node));
                        } else if (neighbour != parent) {
                            // Cycle detected
                            return "Yes";
                        }
                    }
                }
            }
        }

        // No cycle found in any component
        return "No";
    }
}
