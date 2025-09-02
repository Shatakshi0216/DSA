import java.util.* ;
import java.io.*; 
public class Solution {

    public static long sumOrProduct(int n, int q) {
        long MOD = 1000000007;

        if (q == 1) {
            // sum of first n natural numbers
            return (long)n * (n + 1) / 2;
        } else {
            // product of first n natural numbers (factorial) modulo MOD
            long product = 1;
            for (int i = 1; i <= n; i++) {
                product = (product * i) % MOD;
            }
            return product;
        }
    }
}
