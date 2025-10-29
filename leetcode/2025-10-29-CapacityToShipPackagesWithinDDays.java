// min -> max of array 
// max -> in 1 day all are done -> sum of all 
class Solution {
    public int max(int arr[])
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }
    public int sum(int arr[])
    {
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }
    public int daysCount(int arr[],int capacity)
    {
        int days = 1;
        int load = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(load+arr[i]<=capacity)
            {
                load += arr[i];
            }
            else
            {
                days++;
                load = arr[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights);
        int high = sum(weights);
        int mid = 0;
        int result = -1;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(daysCount(weights,mid)<=days)
            {
                result = mid;
                high= mid-1;
            } 
            
            else low=mid+1;
        }
        return result ;
    }
    
}
