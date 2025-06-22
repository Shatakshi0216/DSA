class Solution {
    public int majorityElement(int[] nums) {
        // Jo ele sbse zayada baar hoga dusre bohot kam honge
        int fre = 0;
        int ans = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(fre == 0)
            {
                ans = nums[i];
            }
            if(ans == nums[i])
            {
                fre++;
            }
            else
            {
                fre--;
            }
        }
        return ans;
    }

}
