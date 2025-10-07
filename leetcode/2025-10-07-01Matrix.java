class Pair
{
    int row;
    int col;
    int step;
    Pair(int r,int c,int s)
    {
        row = r;
        col = c;
        step = s;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] visited = new int[m][n];
        
        int[][] dis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        // Initially which are themselves as 0 
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.offer(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }

        int newRow[] = {0,-1,0,+1};
        int newCol[] = {-1,0,+1,0};
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int step = curr.step;

            dis[row][col] = step;
            

            for(int i=0;i<4;i++)
            {
                int r = newRow[i] + row;
                int c = newCol[i] + col;
                int s = step+1;

                if(r>=0 && r<m && c>=0 && c<n && visited[r][c]==0)
                {   
                    q.offer(new Pair(r,c,s));
                    visited[r][c] = 1;
                }
            } 
        }
        return dis;
    }
}
