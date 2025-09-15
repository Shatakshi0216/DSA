import java.util.* ;
import java.io.*; 

public class Solution {
    public static int predictTheWinner(int n, int k) {
        // Write your code here!
        int res = 0;
        for(int i = 2; i < n+1; i++){
            res = (res + k) % i;
        }
        return res + 1;
    }
}
