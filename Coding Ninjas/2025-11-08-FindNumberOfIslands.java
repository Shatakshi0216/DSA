public class Solution 
{
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    
    public static int getTotalIslands(int[][] mat) 
    {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 1 && !vis[i][j]){
                    count++;
                    dfs(i, j, mat, vis, n, m);
                }
            }
        }
        return count;
    }
    
    private static void dfs(int x, int y, int[][] mat, boolean[][] vis, int n, int m){
        vis[x][y] = true;
        
        for(int k=0;k<8;k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if(nx>=0 && ny>=0 && nx<n && ny<m && mat[nx][ny]==1 && !vis[nx][ny]){
                dfs(nx, ny, mat, vis, n, m);
            }
        }
    }
}
