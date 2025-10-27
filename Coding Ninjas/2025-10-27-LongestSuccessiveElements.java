import java.util.*;
public class Solution {
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        Arrays.sort(a);
        int late = Integer.MIN_VALUE;
        int count = 0;
        int largest = 1;
        for(int i=0;i<a.length;i++)
        {
            if(late==a[i]-1)
            {
                count++;
                late = a[i];
            }
            else if(late!=a[i])
            {
                count=1;
                late = a[i];
            }
            largest = Math.max(largest,count);
        }
        return largest;
    }
}
