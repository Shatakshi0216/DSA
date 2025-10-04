class Pair
{
    int row;
    int col;
    
    Pair(int r,int c)
    {
        row = r;
        col = c;
       
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;


        int m = image.length;
        int n = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        int init = image[sr][sc];
        q.offer(new Pair(sr,sc));
        image[sr][sc] = color;
        while(!q.isEmpty())
        {   
            int row = q.peek().row;
            int col = q.peek().col;

            q.poll();
            int newRow[] = {0,-1,0,+1};
            int newCol[] = {-1,0,+1,0};

            
            for(int i=0;i<4;i++)
            {   
                int r = newRow[i] + row;
                int c = newCol[i] + col;

                if(r>=0 && r<m && c>=0 && c<n)
                {
                    if(image[r][c]==init)
                    {
                        q.offer(new Pair(r,c));
                        image[r][c] = color;
                    }
                }
            }
        }
        return image;
    }
}
