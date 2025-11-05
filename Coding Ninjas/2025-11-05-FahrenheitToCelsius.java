import java.util.* ;
import java.io.*; 

public class Solution {

	public static List<List<Integer>> fahrenheitToCelsius(int s, int e, int w) {
		// Write your code here
		int f = s;
		List<List<Integer>> result = new ArrayList<>();
		while(f<=e)
		{
			int c = (int)((f-32)*(5.0/9));
			List<Integer> temp = new ArrayList<>();
			temp.add(f);
			temp.add(c);
			result.add(temp);

			f+=w;
		}
		return result;
	}

}
