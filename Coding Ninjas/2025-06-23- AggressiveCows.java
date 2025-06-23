import java.util.Arrays;
public class Solution {
    public static int max(int arr[])
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max = arr[i];
        }
        return max;
    }
    public static int min(int arr[])
    {
        int min = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<min) min = arr[i];
        }
        return min;
    }
    public static boolean canWePlace(int arr[],int dis,int k)
    {
        int couwCount = 1;
        int last = arr[0];

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-last>=dis)
            {
                last = arr[i];
                couwCount++;
            }
            if(couwCount>=k) return true;
            
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int low = 1;
        int high = max(stalls) - min(stalls);
        int result = -1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(canWePlace(stalls,mid,k)) 
            {   
                low = mid+1;
                result = mid;
            }
            else
            {
                high = mid-1;
            }
            
        }
        return result;
    }
}
