import java.util.* ;
import java.io.*; 
public class Solution {

    public static int oneIteration(int[] A) {
        
        // WRite your Code here
        Arrays.sort(A);
        return A[A.length-1] + A[A.length-2];
    }
}
