class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int minSoFar = nums[0]; // Jo utne m min hoga vhi max difference dega 
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>minSoFar) maxDiff = Math.max(maxDiff,nums[i]-minSoFar);
            else minSoFar = nums[i];
        }
        return maxDiff;
    
    }
}
