import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<Integer> findSubmatrixSum(ArrayList<ArrayList<Integer>> arr, ArrayList<ArrayList<Integer>> queries) {
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(ArrayList<Integer> query : queries)
		{
			int x1 = query.get(0);
			int y1 = query.get(1);
			int x2 = query.get(2);
			int y2 = query.get(3);

			int sum = 0;
			for(int i=x1;i<=x2;i++)
			{
				for(int j=y1;j<=y2;j++)
				{
					sum += arr.get(i).get(j);
				}
			}
			result.add(sum);
		}
		return result;
	}
}
