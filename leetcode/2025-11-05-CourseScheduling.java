class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adj list 
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
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
            if(indegree[i]==0) q.offer(i);
        }

        int count = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            count++;

            for(int neighbour : adj.get(node))
            {
                indegree[neighbour]--;
                if(indegree[neighbour]==0) q.offer(neighbour);
            }
        }
        return count==numCourses;
    }
}
