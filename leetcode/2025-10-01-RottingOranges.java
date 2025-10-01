class Pair
{
    int row;
    int col;
    int time;
    Pair(int r,int c,int t)
    {
        row = r;
        col = c;
        time = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int visited[][] = new int[n][m];
        int countFresh = 0;
        for(int i=0;i<n;i++) // How many 2 at starting 
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                else 
                {
                    visited[i][j] = 0;
                }
                if(grid[i][j]==1) countFresh++; // How many are fresh in starting 
            }
        }

        int time = 0;   
        int delRow[] = {0,-1,0,+1};
        int delCol[] = {-1,0,+1,0};
        int cnt = 0; // How many fresh oranges got rotten 
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.poll();

            

            time  = Math.max(time,t);

            for(int i=0;i<4;i++)
            {
                int newRow = r+delRow[i];
                int newCol = c+delCol[i];

                // Check for valid
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m)
                {
                    if(visited[newRow][newCol]==0 && grid[newRow][newCol]==1)
                    {
                        // Make it rotten 
                        q.add(new Pair(newRow,newCol,t+1));
                        visited[newRow][newCol] = 2;
                        cnt++; // One fresh orange rotten 
                    }
                }
            }    
            
        
        }
        // If all fresh oranges are rotten 
        if(cnt==countFresh) return time;
        return -1;
        
    }
}
