public class Solution {
    public static boolean isPalindrome(String str) {
        return helper(str, 0, str.length() - 1);
    }

    private static boolean helper(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return helper(s, l + 1, r - 1);
    }
}
