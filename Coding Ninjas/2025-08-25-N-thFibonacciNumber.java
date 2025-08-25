import java.util.*;

public class Solution {
    static final int MOD = 1000000007;

    // Function to multiply two matrices
    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] res = new long[2][2];
        res[0][0] = (A[0][0] * B[0][0] % MOD + A[0][1] * B[1][0] % MOD) % MOD;
        res[0][1] = (A[0][0] * B[0][1] % MOD + A[0][1] * B[1][1] % MOD) % MOD;
        res[1][0] = (A[1][0] * B[0][0] % MOD + A[1][1] * B[1][0] % MOD) % MOD;
        res[1][1] = (A[1][0] * B[0][1] % MOD + A[1][1] * B[1][1] % MOD) % MOD;
        return res;
    }

    // Function to perform fast exponentiation of matrix
    private static long[][] power(long[][] M, int n) {
        if (n == 1) return M;
        if (n % 2 == 0) {
            long[][] half = power(M, n / 2);
            return multiply(half, half);
        } else {
            return multiply(M, power(M, n - 1));
        }
    }

    public static int fibonacciNumber(int n) {
        if (n == 1 || n == 2) return 1;

        long[][] base = { {1, 1}, {1, 0} };
        long[][] result = power(base, n - 1);

        return (int) (result[0][0] % MOD); // F(n)
    }
}
