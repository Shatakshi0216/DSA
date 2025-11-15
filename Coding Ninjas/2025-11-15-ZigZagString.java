import java.util.* ;
import java.io.*; 
public class Solution {
    public static String zigZagString(String str, int n, int m) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        if( m==1 || n<=m) return str;
        int row = 0;
        int cycle = 2*m - 2; 
        while(row<m)
        {   
            int k = row;
            while(k<n)
            {
                // Always take vertical character 
                sb.append(str.charAt(k));

                // For middle rows -> also take digonal characters  
                if(row!=0 && row!=m-1)
                {
                    int diag = k + (cycle-2*row);
                    if(diag<n) sb.append(str.charAt(diag));
                }
                k += cycle;
            }
            row++;
            
        }
        return sb.toString();
        
    }
}
