class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i=0;
        while(i<nums.length)
        {   
            int j = i;
            while(j<nums.length && nums[j]-nums[i]<=k) j++;
            count++;
            i=j;
        }
        return count;
    }
}
