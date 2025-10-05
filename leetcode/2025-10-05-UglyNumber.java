class Solution {
    public boolean isUgly(int n) {
        // Ugly numbers are positive only
        if (n <= 0) return false;

        // Keep dividing by 2, 3, and 5 while possible
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        // After removing all 2, 3, and 5 factors,
        // if n becomes 1 → it's ugly
        return n == 1;
    }
}
