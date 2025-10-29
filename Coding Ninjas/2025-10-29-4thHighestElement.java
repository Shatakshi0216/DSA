public class Solution 
{    
    public static int getFourthLargest(int[] arr) 
    {
        // Sort the array in descending order
        java.util.Arrays.sort(arr);
        
        // Reverse order to get descending
        int n = arr.length;
        if(n < 4)
            return -2147483648; // Minimum integer value
        
        return arr[n - 4]; // 4th largest element
    }
}
