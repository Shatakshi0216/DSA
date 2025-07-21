import java.io.*;
import java.util.*;

public class Solution {
	public static int findMajority(int[] arr, int n) {
		int fre = 0;
        int ans = 0;

        // Step 1: Find candidate
        for(int i = 0; i < n; i++) {
            if(fre == 0) {
                ans = arr[i];
            }

            if(ans == arr[i]) {
                fre++;
            } else {
                fre--;
            }
        }

        // Step 2: Verify candidate
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == ans) count++;
        }

        if(count > n / 2) return ans;
        else return -1; // No majority element
	}
}
