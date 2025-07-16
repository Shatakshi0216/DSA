import java.util.HashMap;

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int i=0;
        int j=0;
        long sum=a[0];
        int len=0;
        while(j<a.length)
        {   
            while(i<=j && sum>k)
            {
                sum-=a[i];
                i++;
            }
            if(sum==k)
            {
                len = Math.max(len,j-i+1);
            }
            j++;
            if(j<a.length)
            {
                sum+=a[j];
            }
        }
        
        return len;

    }
}
