import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static boolean ninjaShikanji(ArrayList<Integer> bill, int n) {
		// Write your code here.
		int five = 0,ten=0;
		for(int i=0;i<n;i++)
		{
			int curr = bill.get(i);
			if(curr==5) five++;
			else if(curr==10)
			{	
				if(five==0) return false;
				if(five>0)
				{
					five--;
					ten++;
				}
			}
			else if(curr==20)
			{	
				if(ten>0 && five>0)
				{
					five--;
					ten--;
				}
				else if(five>=3)
				{
					five-=3;
				}
				
				else
				{
					return false;
				}
			}
		}
		return true;
	}
}
