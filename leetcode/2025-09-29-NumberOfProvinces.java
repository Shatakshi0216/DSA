class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adjList,int visited[],int i)
    {
        visited[i] = 1;
        for(int neighbour : adjList.get(i))
        {
            if(visited[neighbour]==0)
            {
                dfs(adjList,visited,neighbour);
            }      
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int visited[]= new int[n];
        int count = 0;
        // No of provinces = no. of components 

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Converting adj matrix into adj list
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adjList.get(i).add(j);
                }
            }
        }

        // We can count it by counting how many times DFS is called
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                count++;
                dfs(adjList,visited,i);
            }
        }
        return count;
    }
}
