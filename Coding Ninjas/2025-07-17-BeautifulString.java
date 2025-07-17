public class Solution {
    public static int makeBeautiful(String str) {
        int countStartWith0 = 0; // pattern: 0101...
        int countStartWith1 = 0; // pattern: 1010...

        for (int i = 0; i < str.length(); i++) {
            char actual = str.charAt(i);
            char expected0 = (i % 2 == 0) ? '0' : '1'; // Pattern starting with 0
            char expected1 = (i % 2 == 0) ? '1' : '0'; // Pattern starting with 1

            if (actual != expected0) countStartWith0++;
            if (actual != expected1) countStartWith1++;
        }

        return Math.min(countStartWith0, countStartWith1);
    }
}
