import java.util.* ;
import java.io.*; 
public class Solution {
	public static int[] giftsLeft(int n, int k, int q, int[] demands) {
		// Write your code here.
		int gifts = n;
		int arr[] = new int[q];
		for(int i=0;i<q;i++)
		{	
			if(demands[i]>gifts) arr[i] = -1;
			else
			{
				gifts = gifts-demands[i];
				if(gifts<k) gifts = n;
				arr[i] = gifts;	
			}
			
		}
		return arr;
	}
}
