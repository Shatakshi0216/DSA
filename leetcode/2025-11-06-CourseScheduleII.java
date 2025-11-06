class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ansList = new ArrayList<>(); 
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int pre[] : prerequisites)
        {
            int course = pre[0];
            int prereq = pre[1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            } 
        }

        while(!q.isEmpty())
        {
            int node = q.poll();
            ansList.add(node);
            for(int neighbour : adj.get(node))
            {   
                indegree[neighbour]--;
                if(indegree[neighbour]==0) 
                {    
                    q.offer(neighbour);
                }
            }
        }
        if(ansList.size()!=numCourses) return new int[0];
        int ans[] = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
