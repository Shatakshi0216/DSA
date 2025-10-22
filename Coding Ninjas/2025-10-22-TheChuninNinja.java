import java.util.* ;
import java.io.*; 
import java.util.Vector;

public class Solution {
    public static Vector < Integer > chuninNinja(int n, int m, int arr[][]) {
        // Write your code here.
        Vector < Integer > ans = new Vector<>();
        int rowMin[] = new int[n];
        int colMax[] = new int[m];

        // Finding min in each row 
        for(int i=0;i<n;i++)
        {
            int minVal = Integer.MAX_VALUE;
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]<minVal) minVal = arr[i][j];
            }
            rowMin[i] = minVal;
        }
        // Finding max in each col 
        for(int j=0;j<m;j++)
        {
            int maxValue = Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                if(arr[i][j]>maxValue) maxValue = arr[i][j];
            }
            colMax[j] = maxValue;
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==rowMin[i] && arr[i][j]==colMax[j]) 
                {
                    ans.add(arr[i][j]);
                }
            }
        }
        return ans;
    }
}
