public class Solution {
    public static int[] findRepeatingAndMissingNumbers(int[] nums) {
        int n = nums.length;

        long S = (long) n * (n + 1) / 2;                 // expected sum
        long P = (long) n * (n + 1) * (2L * n + 1) / 6;  // expected sum of squares

        long S1 = 0, P1 = 0;
        for (int num : nums) {
            S1 += num;
            P1 += (long) num * num;
        }

        long diff1 = S1 - S;       // rep - miss
        long diff2 = P1 - P;       // rep^2 - miss^2

        long sumRM = diff2 / diff1;   // rep + miss

        long rep = (diff1 + sumRM) / 2;
        long miss = rep - diff1;

        return new int[] {(int) rep, (int) miss};
    }
}
