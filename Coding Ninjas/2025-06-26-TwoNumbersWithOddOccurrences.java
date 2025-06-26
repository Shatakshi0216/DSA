public class Solution {
    public static int[] twoOddNum(int []arr){
        // Write your code here.
        int xor = 0;
        for(int i=0;i<arr.length;i++)
        {
            xor = xor^arr[i];
        }
        int rightMost = ((xor & (xor-1)) ^ xor);
        int b1 = 0;
        int b2 = 0;
        for(int i=0;i<arr.length;i++)
        {
            if((arr[i] & rightMost) != 0) b1 = b1^arr[i];
            else b2 = b2^arr[i];
        }
        if (b1 > b2) return new int[]{b1, b2};
        else return new int[]{b2, b1};
    }
}
