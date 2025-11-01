class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long even = (n + 1) / 2; // even positions
        long odd = n / 2;        // odd positions
        
        long ans = (power(5, even, mod) * power(4, odd, mod)) % mod;
        return (int) ans;
    }

    // fast power function
    long power(long x, long y, long mod) {
        long res = 1;
        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % mod;
            x = (x * x) % mod;
            y = y / 2;
        }
        return res;
    }
}
