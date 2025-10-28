public class Solution {

    public static char highestOccuringChar(String str) {
        // Edge case: empty string
        if (str.length() == 0) return '\0'; // null character

        // Array to store frequency of each character (a-z)
        int[] freq = new int[26];

        // Step 1: Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;   // index 0 for 'a', 1 for 'b', etc.
        }

        // Step 2: Find the highest frequency and its character
        int maxFreq = -1;
        char result = '\0';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch - 'a'] > maxFreq) {
                maxFreq = freq[ch - 'a'];
                result = ch;
            }
        }

        return result;
    }
}
