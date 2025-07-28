public class Solution {
    public static int removeDuplicates(int[] arr,int n) {
        // Write your code here.
        int i = 0;
        int j = 1;
        while(j<n)
        {
            if(arr[i]!=arr[j])
                arr[++i] = arr[j];
             j++;
        }
        return i+1;
    }
}
