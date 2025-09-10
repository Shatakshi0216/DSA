import java.util.* ;
import java.io.*; 
public class Solution {
    public static int numberofSubarrays(int n, int[] arr) {
        // Write your code here.
        int total = 0;
        int cnt = 1;

        for(int i = 1; i < n; i++){
            if (arr[i] == arr[i-1]){
                cnt++;
            }
            else{
                total += (cnt * (cnt + 1)) / 2;
                cnt = 1;
            }
        }
        total += (cnt * (cnt + 1)) / 2;

        return total;
    }
}
