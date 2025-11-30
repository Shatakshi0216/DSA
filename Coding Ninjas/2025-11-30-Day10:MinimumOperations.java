import java.util.* ;
import java.io.*; 
public class Solution {	
	public static int minimumOperation(int[] arr, int n) {
    if (n <= 1) return 0;
    java.util.HashMap<Integer, Integer> freq = new java.util.HashMap<>();
    int maxFreq = 0;
    for (int v : arr) {
        int f = freq.getOrDefault(v, 0) + 1;
        freq.put(v, f);
        if (f > maxFreq) maxFreq = f;
    }
    return n - maxFreq;
    }
}


