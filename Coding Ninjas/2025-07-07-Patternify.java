import java.util.* ;
import java.io.*; 

public class Solution {
	public static String[] printPatt(int n) {
		String[] result = new String[n];
		// Write your code here
		for(int i=0;i<n;i++)
		{	
			StringBuilder line = new StringBuilder();
			for(int j=0;j<n-i;j++)
			{
				line.append("*");
			}
			result[i] = line.toString();
		}
		return result;
	}

}
