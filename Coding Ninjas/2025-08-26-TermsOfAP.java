import java.util.* ;
import java.io.*; 
public class Solution {
	public static int[] termsOfAP(int x){
		// Write your code here.
		List<Integer> result = new ArrayList<>();
		int i = 1;
		while(result.size()<x)
		{
			int term = 3*i + 2;
			if(term%4!=0) result.add(3*i + 2);
			i++;
		}
		int arr[] = new int[result.size()];
		for(int j=0;j<result.size();j++)
		{
			arr[j] = result.get(j);
		}
		return arr;
	}
}
