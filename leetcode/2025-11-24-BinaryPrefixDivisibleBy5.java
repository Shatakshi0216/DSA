class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int num = 0;
        for(int i=0;i<nums.length;i++)
        {   
            num = (num*2+nums[i])%5;
            if(num==0) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}
