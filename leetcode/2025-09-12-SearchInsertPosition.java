class Solution {
    public int searchInsert(int[] nums, int t) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==t) return m;
            else if(nums[m]<t) l=m+1;
            else r=m-1;
        }
        return l;
    }
}
