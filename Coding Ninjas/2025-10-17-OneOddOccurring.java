public class Solution{
    public static int missingNumber(int n, int []arr){
        // Write your code here.
        int result = 0;
        for(int i=0;i<n;i++)
        {
            result ^= arr[i];
        }
        return result;
    }
}
