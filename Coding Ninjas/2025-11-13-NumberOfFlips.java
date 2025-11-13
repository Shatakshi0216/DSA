import java.util.* ;
import java.io.*; 

public class Solution {

    public static int numberOfFlips(int a, int b) {
        // XOR finds differing bits
        int x = a ^ b;
        
        // Count set bits in XOR result
        int count = 0;
        while (x > 0) {
            count += (x & 1);
            x >>= 1;
        }
        
        return count;
    }
}
