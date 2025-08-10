import java.util.* ;
import java.io.*; 
public class Solution {
	
	public static boolean ninjaGram(String str) {
		// Write your code here
		str = str.toLowerCase();

		boolean[] present = new boolean[26];

		int cnt = 0;

		for(char c: str.toCharArray()){
			if (c >= 'a' && c <= 'z'){
				int idx = c - 'a';
				if (!present[idx]){
					present[idx] = true;
					cnt++;
				}
				if (cnt == 26){
					return true;
				}
			}
		}

		return cnt == 26;
	}
}
