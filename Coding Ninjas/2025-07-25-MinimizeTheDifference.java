import java.util.* ;
import java.io.*; 

public class Solution {

    public static int minimizeIt(int[] A, int K) {
        // Write your code here.
        int n = A.length;
        Arrays.sort(A);
        int ans = A[n-1] - A[0]; // Original
        int smallest = A[0] + K;
        int largest = A[n-1] - K;

        for(int i=0;i<n-1;i++)
        {
            int minVal = Math.min(smallest,A[i+1]-K);
            int maxVal = Math.max(largest,A[i]+K);
            if(minVal<0) continue;

            ans = Math.min(ans,(maxVal-minVal));
        }
        return ans;
    }
}
