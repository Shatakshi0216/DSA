import java.util.ArrayList;

public class Solution {
  public static boolean dfs(int i, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj) {
    vis[i] = 1;
    pathVis[i] = 1;

    for (int neighbour : adj.get(i)) {
      if (vis[neighbour] == 0) {
        if (dfs(neighbour, vis, pathVis, adj)) return true;
      } else if (pathVis[neighbour] == 1) return true; 
    }

    pathVis[i] = 0;
    return false;
  }

  public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
    int[] vis = new int[n + 1];      
    int[] pathVis = new int[n + 1];  
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) adj.add(new ArrayList<>()); 

    
    for (ArrayList<Integer> e : edges) {
      int u = e.get(0);
      int v = e.get(1);
      adj.get(u).add(v);
    }

    
    for (int i = 1; i <= n; i++) {
      if (vis[i] == 0) {
        if (dfs(i, vis, pathVis, adj)) return true;
      }
    }

    return false;
  }
}
