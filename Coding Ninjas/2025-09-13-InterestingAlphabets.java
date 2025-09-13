import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<ArrayList<Character>> interestingPattern(int N) {

		// Write your code here.
		 ArrayList<ArrayList<Character>> result = new  ArrayList<>();
		for(int i=1;i<=N;i++)
		{	
			char ch = (char)('A'+N-1);
			ArrayList<Character> temp = new ArrayList<>();
			for(int j=1;j<=i;j++)
			{
				temp.add((char)(ch-i+j));
			} 
			result.add(temp); 
		}
		return result;
	}
}
