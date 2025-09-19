import java.util.* ;
import java.io.*; 

public class Solution {
    public static long titleToNumber(String str) {
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'A' + 1;  // Convert 'A' ? 1, 'B' ? 2 ? 'Z' ? 26
            result = result * 26 + value;         // Build like base-26 number
        }
        return result;
    }

    // Driver for multiple test cases
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();    // number of test cases
        while (T-- > 0) {
            String str = sc.next();
            System.out.println(titleToNumber(str));
        }
    }
}
