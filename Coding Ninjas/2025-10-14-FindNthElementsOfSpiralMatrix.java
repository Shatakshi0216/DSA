import java.util.* ;
import java.io.*; 
public class Solution {

	public static int findKthElement(int[][] matrix, int k) {
	    // Write your code here.
		int n = matrix.length;
		int m = matrix[0].length;
		int top = 0;
		int left = 0;
		int right = m-1;
		int bottom = n-1;
		int count = 0;
		while(left<=right && top<=bottom)
		{
			 
			for(int i=left;i<=right;i++)
			{	
				count++;
				if(count==k) return matrix[top][i];
			}
			top++;
			for(int i=top;i<=bottom;i++)
			{	
				count++;
				if(count==k) return matrix[i][right];
			}
			right--;

			if(top<=bottom)
			{
				for(int i=right;i>=left;i--)
				{
					count++;
					if(count==k) return matrix[bottom][i];
				}
			}
			bottom--;

			if(left<=right)
			{
				for(int i=bottom;i>=top;i--)
				{
					count++;
				    if(count==k) return matrix[i][left];
				}
			}
			left++;

		}
		return -1;
	}
}
