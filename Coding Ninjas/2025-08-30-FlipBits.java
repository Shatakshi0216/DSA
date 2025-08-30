import java.util.* ;
import java.io.*; 
public class Solution {
	public static int flipBits(int[] arr, int n) {
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                totalOnes++;
            }
        }

        if (totalOnes == n) {
            return n;
        }

        int maxGain = 0;
        int currentGain = 0;

        for (int i = 0; i < n; i++) {
            int value = (arr[i] == 0) ? 1 : -1;
            
            currentGain += value;

            if (currentGain < 0) {
                currentGain = 0;
            }

            if (currentGain > maxGain) {
                maxGain = currentGain;
            }
        }

        return totalOnes + maxGain;
	}
}

