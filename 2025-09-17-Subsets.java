class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int num=0;num<=((1<<n)-1);num++)
        {
            List<Integer> lst = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                if((num & (1<<i))!=0) lst.add(nums[i]);
            }
            ans.add(lst);
        }
        return ans;
    }
}
