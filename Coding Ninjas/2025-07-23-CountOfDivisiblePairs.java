import java.util.* ;
import java.io.*; 
public class Solution {
    static int countOfDivisiblePairs(int n, int m) {
        // Write your code here.
        int count = 0;
        for(int x=1;x<=n;x++)
        {
            for(int y = 1;y<=m;y++)
            {
                if((x+y)%5 == 0) count++;
            }
        }
        return count;
    }

}
