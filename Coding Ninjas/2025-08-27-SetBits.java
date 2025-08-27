import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countSetBits(int n) {
		// Write your code here.
		int count = 0;
		while(n!=0)
		{
			n = n & (n-1);
			count++;
		}
		return count;
	}
}
