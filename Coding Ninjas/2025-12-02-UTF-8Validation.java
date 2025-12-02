import java.util.* ;
import java.io.*; 

public class Solution {
    public static boolean validUtf8(ArrayList<Integer> data) {

        int remaining = 0;  // Number of continuation bytes needed

        for (int num : data) {

            // Only lowest 8 bits matter
            int b = num & 0xFF;

            if (remaining == 0) {
                // Count leading 1s
                if ((b >> 7) == 0) {
                    // 0xxxxxxx -> 1-byte char
                    continue;
                }

                int count = 0;
                int mask = 0x80;   // 1000 0000

                while ((b & mask) != 0) {
                    count++;
                    mask >>= 1;
                }

                // invalid cases
                if (count == 1 || count > 4) return false;

                remaining = count - 1;  // continuation bytes needed

            } else {
                // Continuation byte must be 10xxxxxx
                if ((b >> 6) != 0b10) return false;
                remaining--;
            }
        }

        return remaining == 0;
    }
}
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;

        while (i < n - 1) {       // stop before the last bit
            if (bits[i] == 1) {
                i += 2;          // two-bit character
            } else {
                i += 1;          // one-bit character
            }
        }

        // If we stopped exactly at last index -> it's a one-bit character
        return i == n - 1;
    }
}
