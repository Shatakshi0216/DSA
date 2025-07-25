class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer,1);
        int prefix = 1;
        int suffix = 1;
        for(int i=1;i<nums.length;i++)
        {
            prefix = prefix*nums[i-1];
            answer[i] = prefix;
        }
        for(int i=nums.length-2;i>=0;i--)
        {
            suffix = nums[i+1]*suffix;
            answer[i] = answer[i]*suffix;
        }
    
        return answer;
    }
}
