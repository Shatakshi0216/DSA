class Solution {

    // Reverse string using two pointer approach (your style)
    public String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        int j = sb.length() - 1;

        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);

            i++;
            j--;
        }

        return sb.toString();
    }

    // Count bit positions where original and reversed binary differ
    public int minimumFlips(int n) {
        int flips = 0;

        String original = Integer.toBinaryString(n);
        String rev = reverse(original);

        // Compare both strings index by index
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != rev.charAt(i)) {
                flips++;
            }
        }

        return flips;
    }

    // For local testing (not required on platforms like LeetCode)
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minimumFlips(10)); // 1010 vs 0101 → 4 flips
    }
}
