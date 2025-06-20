public class Solution {
    public static int findXOR(int L, int R){
        // Write your code here.
        int xor = 0;
        for(int i=L;i<=R;i++)
        {
            xor = xor^i;
        }
        return xor;
    }
}
