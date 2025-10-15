class Solution {
    public int max(int arr[])
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max) max = arr[i];
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
    public int noOfParts(int arr[],int partsPossible)
    {   
        int sets = 1;
        int parts = 0;
    
        for(int i=0;i<arr.length;i++)
        {
            if(parts+arr[i]<=partsPossible)
            {
                parts+=arr[i];
            }
            else
            {
                sets++;
                parts = arr[i];
            }
        }
        return sets;
    }
    public int splitArray(int[] nums, int k) {
        int low = max(nums);
        int high = sum(nums);

        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(noOfParts(nums,mid)>k)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;
    }
}
