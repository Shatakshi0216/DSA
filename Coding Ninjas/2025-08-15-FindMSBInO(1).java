import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findMSB(int n) {
        // Write your code here.
        int msb = 1;
        while(n>1)
        {
           n =  n>>1;
           msb = msb<<1;

        }
        return msb;
    }
}
