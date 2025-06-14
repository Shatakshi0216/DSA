public class Solution {
    public static int removeDuplicates(int[] arr,int n) {
        // Write your code here.
        if(n==0) return 0;
        int k = 0;
        for(int i=1;i<n;i++)
        {
            if(arr[k]!=arr[i])
            {
                k++;
                arr[k] = arr[i];
            }
        }
        for(int i=k+1;i<n;i++)
        {
            arr[k] = Integer.MIN_VALUE;
        }
        return k+1;
    }
}
