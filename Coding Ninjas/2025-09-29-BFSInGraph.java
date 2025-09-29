import java.util.*;

public class Solution {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        //Start BFS from 0 (not a loop over all nodes)
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            for (int neighbour : adj.get(curr)) {
                if (!visited[neighbour]) {
                    q.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return result;
    }
}
