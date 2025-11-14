import java.util.*;
public class Solution {
    public static void dfs(Stack<Character> st,int[] vis,int i,List<List<Integer>> adj)
    {
        vis[i] = 1;
        for(int neighbour : adj.get(i))
        {   
            if(vis[neighbour]==0)
            {
                dfs(st,vis,neighbour,adj);
            }
            
        }
        st.push((char)(i+'a'));
    }
    public static String getAlienLanguage(String []dictionary, int k) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        int n = dictionary.length;
        List<List<Integer>> adj = new ArrayList<>(); 
        
        for(int i=0;i<k;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++)
        {
            String w1 = dictionary[i];
            String w2 = dictionary[i+1];

            int len = Math.min(w1.length(),w2.length());

            for(int j=0;j<len;j++)
            {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                 
                if(c1!=c2) // c1 comes before c2 -> c1->c2
                {   
                    // get method accepts index so converting them in index
                    int u = c1-'a';
                    int v = c2-'a';
                    
                    adj.get(u).add(v);
                    break;
                }
            }
        }

        // Topo sort 
        Stack<Character> st = new Stack<>();
        int[] vis = new int[k];
        for(int i=0;i<k;i++)
        {
            if(vis[i]==0) dfs(st,vis,i,adj);
        }
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
