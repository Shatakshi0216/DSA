import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Integer>> multilication(ArrayList<ArrayList<Integer>> arr)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for(int i=0;i<arr.size();i++)
		{
			ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(arr.size(),0));
			result.add(row);
		}
		for(int i=0;i<arr.size();i++)
		{
			for(int j=0;j<arr.size();j++)
			{	
				int sum = 0;
				for(int k=0;k<arr.size();k++)
				{
					sum += arr.get(i).get(k) * arr.get(k).get(j);
				}
				result.get(i).set(j,sum);
			}
		}
		return result;
	}
	public static boolean matrixGame(ArrayList<ArrayList<Integer>> arr) {

		// Write your code here
		ArrayList<ArrayList<Integer>> multiplied = new ArrayList<>();
		multiplied = multilication(arr);
		for(int i=0;i<arr.size();i++)
		{
			for(int j=0;j<arr.size();j++)
			{
				if(!arr.get(i).get(j).equals(multiplied.get(i).get(j))) return false;
			}
		}
		return true;
	}
}
