/*
🔹 Definition from the problem

“A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).”

So in plain words:
✅ A safe node is one from which no path ever enters a cycle.
*/
class Solution {
    public boolean dfs(int i,int[] vis,int[] pathVis,int[][] graph,boolean[] safe)
    {
        vis[i] = 1;
        pathVis[i] = 1;

        for(int neighbour : graph[i])
        {   
            if(vis[neighbour]==0)
            {
                if(!dfs(neighbour,vis,pathVis,graph,safe)) return false;
            }
            else if(pathVis[neighbour]==1) return false;
        }
        pathVis[i] = 0;
        safe[i] = true;
        return true;

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        boolean[] safe = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0) 
            {   
                dfs(i,vis,pathVis,graph,safe);
            }
        }
        List<Integer> safeList = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(safe[i]) safeList.add(i);
        }
        return safeList;
    }
}
