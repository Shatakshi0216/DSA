class Solution {
    public int helper(int arr[],int goal)
    {   
        if(goal==-1) return 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while(r<arr.length)
        {
            sum += arr[r];
            while(sum>goal)
            {   
                sum -= arr[l];
                l++;
                
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans =  helper(nums,goal)-helper(nums,goal-1);
        return ans;
    }
}
