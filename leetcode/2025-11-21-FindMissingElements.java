class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int start = nums[0];
        int end = nums[nums.length-1];

        int ele = start;
        while(ele!=end)
        {
            ele++;
            if(!set.contains(ele)) ans.add(ele);
        }
        return ans;
    }
}
