import java.util.* ;
import java.io.*; 
public class Solution {
	public static void sortTuples(int[][] arr) {
		// Write your code here.
		int tuple[] = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			tuple[i] = arr[i][arr[0].length-1];
			
		}
		Arrays.sort(arr,new Comparator<int[]>()
		{
			public int compare(int[] a,int[] b)
			{
				return Integer.compare(a[a.length-1],b[b.length-1]);
			}
		});
	}
}
