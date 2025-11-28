import java.util.* ;
import java.io.*; 

public class Solution {
	public static int[] wavePrint(int arr[][], int nRows, int mCols) {
		// Write your code here.

		int result[] = new int[mCols*nRows];
		int k = 0;
		for(int j=0;j<mCols;j++)
		{	
			if(j%2==0)
			{
				for(int i=0;i<nRows;i++)
				{
					result[k++] = arr[i][j];
				}
			}
			else
			{
				for(int i=nRows-1;i>=0;i--)
				{
					result[k++] = arr[i][j];
				}
			}
			
		}
			
		return result;
	}
}


