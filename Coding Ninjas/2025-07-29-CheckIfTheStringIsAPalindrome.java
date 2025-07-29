import java.util.* ;
import java.io.*; 
public class Solution {

	public static boolean checkPalindrome(String str) {
	
	    // WRITE YOUR CODE HERE	
		int i = 0;
		int j = str.length()-1;
		
		while(i<j)
		{
			while(i<j && !Character.isLetterOrDigit(str.charAt(i))) i++;
			while(i<j && !Character.isLetterOrDigit(str.charAt(j))) j--;
			

			if(Character.toLowerCase(str.charAt(i))!=Character.toLowerCase(str.charAt(j))) return false;
			i++;
			j--;
		}
	 	return true;
	}
}
