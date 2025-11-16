class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        if(nums.length<3) return -1;
        Arrays.sort(nums);
        int a = nums[nums.length-2];
        int b = nums[nums.length-1];
        int c = nums[0];

        return a+b-c;
    }
}
