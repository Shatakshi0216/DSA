import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static ArrayList<Integer> findAnagramsIndices(String str, int n, String ptr, int m){
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();

        int[] cntPTr = new int[26];
        int[] cntStr = new int[26];

        for(int i = 0; i < m; i++){
            cntPTr[ptr.charAt(i) - 'A']++;
            cntStr[str.charAt(i) - 'A']++;
        }

        if(Arrays.equals(cntPTr, cntStr)){
            result.add(0);
        }

        for(int i = m; i < n; i++){
            cntStr[str.charAt(i - m) - 'A']--;
            cntStr[str.charAt(i) - 'A']++;

            if(Arrays.equals(cntPTr, cntStr)){
                result.add(i - m + 1);
            }
        }

        return result;

    }
}
