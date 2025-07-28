class Solution {
    public boolean canJump(int[] nums) {
        int n  = nums.length;
        int maxJumpTo = 0;
        for(int i=0;i<n;i++)
        {   
            if(maxJumpTo<i) return false;
            int jumps = i+nums[i];
            maxJumpTo = Math.max(maxJumpTo,jumps);
            
            
        }
        return true;
    }
}
