class Solution {
    public int[] getConcatenation(int[] nums) {
        /*int n = nums.length;
        int[] ans = new int[2*n];
        for(int i=0;i<n;i++)
        {
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;*/

        //OR

        int n = nums.length;
        int[] resultArray = new int[n * 2];
        System.arraycopy(nums, 0,resultArray,0, n);
        System.arraycopy(nums, 0,resultArray,n, n);
        return resultArray;
    }
}
