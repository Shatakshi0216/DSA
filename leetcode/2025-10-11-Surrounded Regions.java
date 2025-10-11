class Solution {
    public void dfs(int[][] visited,int i,int j,char[][] board,int m,int n)
    {
        if(i<0 || i>=m || j<0 || j>=n) return;
        if(visited[i][j]==1) return;
        if(board[i][j]=='X') return;

        visited[i][j] = 1;

        dfs(visited, i+1, j,board,m,n);
        dfs(visited, i-1, j,board,m,n);
        dfs(visited, i, j+1,board,m,n);
        dfs(visited, i, j-1,board,m,n);

        
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int visited[][] = new int[m][n];
        
         
        
        for(int j=0;j<n;j++)
        {
            if(visited[0][j]==0)
            {
                dfs(visited,0,j,board,m,n);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(visited[i][n-1]==0)
            {
                dfs(visited,i,n-1,board,m,n);
            }
        }
        for(int j=0;j<n;j++)
        {
            if(visited[m-1][j]==0)
            {
                dfs(visited,m-1,j,board,m,n);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(visited[i][0]==0)
            {
                dfs(visited,i,0,board,m,n);
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && visited[i][j]==0) board[i][j] = 'X';
            }
        }
    }
}
