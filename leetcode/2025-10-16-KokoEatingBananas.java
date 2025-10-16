// ans will always equal to low -> opposite polarity 
class Solution {
    public int max(int arr[])
    {
        int max = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    public int requiredTime(int []piles,int hourly)
    {
        int totalTime = 0;
        for(int i=0;i<piles.length;i++)
        {
            totalTime += Math.ceil((double)piles[i]/hourly);
            
        }
        return totalTime;
        
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        int mid = 0;
        
        while(low<=high)
        {   
            mid = low+(high-low)/2;
            if(requiredTime(piles,mid)<=h)
            {
                
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }
}
