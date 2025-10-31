import java.util.* ;
import java.io.*; 
public class Solution 
{   
    public static void dfs(int i,int vis[],Stack st,ArrayList<ArrayList<Integer>> adj)
    {
        vis[i] = 1;
        for(int it : adj.get(i))
        {
            if(vis[it]==0)
            {
                dfs(it,vis,st,adj);
            }
        }
        st.push(i);

    }
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {   
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge : edges)
        {
            int u = edge.get(0);
            int w = edge.get(1);

            adj.get(u).add(w);
        }
        // Write your code here
        Stack<Integer> st = new Stack<>();
        int vis[] = new int[v];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,st,adj);
            }
        }
        while(!st.isEmpty())
        {
            result.add(st.pop());
        }
        return result;
    }
}
