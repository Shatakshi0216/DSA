import java.util.* ;
import java.io.*; 
import  java.util.ArrayList;

public class Solution {
    public static int gridOverlap(ArrayList<ArrayList<Integer>> mat1, ArrayList<ArrayList<Integer>> mat2, int n)  {
        // Write your code here
        int maxOveralp = 0;
        for(int dx=-n+1;dx<n;dx++){
            for(int dy=-n+1;dy<n;dy++)
            {
                int overlap = 0;

                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        int newI = i+dx;
                        int newJ = j+dy;

                        if(newI>=0 && newI<n && newJ>=0 && newJ<n)
                        {
                            if(mat1.get(i).get(j)==1 && mat2.get(newI).get(newJ)==1)
                            {
                                overlap++;
                            }
                        }
                    }
                }
                maxOveralp = Math.max(maxOveralp,overlap);
            }
        }
        return maxOveralp;
        
    }
}
