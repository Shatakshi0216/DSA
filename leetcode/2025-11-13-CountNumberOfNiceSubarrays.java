class Solution {
    public int atmostK(int[] nums,int k)
    {
        int l = 0;
        int r = 0;
        int odd = 0;
        int ans = 0;
        while(r<nums.length)
        {   
            if(nums[r]%2!=0)
            {
                odd++;
            }
            while(odd>k)
            {
                if(nums[l]%2!=0) odd--;
                l++;
            }
            ans += r-l+1;
            r++;
            
            
        }

        return ans;
    }   
    public int numberOfSubarrays(int[] nums, int k) {
        int result = atmostK(nums,k) - atmostK(nums,k-1);
        return result;
    }
}
