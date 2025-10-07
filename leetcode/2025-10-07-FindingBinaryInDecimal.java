import java.util.* ;
import java.io.*; 
public class Solution {
	public static boolean helper(long i)
	{	
		if(i==0) return true; 	
		while(i>0)
		{
			long rem = i%10;
			if(rem!=0 && rem!=1) return false;
			i = i/10;

		}
		return true;
	}
    public static long countOfNumbers(long n) {
		// Write your code here.
		long count = 0;
		for(long i=1;i<=n;i++)
		{
			if(helper(i))
			{
				count++;
			}
			
		}
		return count;
	}
}
