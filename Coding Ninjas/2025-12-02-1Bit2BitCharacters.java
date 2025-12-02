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
