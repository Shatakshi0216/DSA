class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> count=new HashSet<>();
        int maxLen=0;
        for(int i=0;i<nums.length;i++)
        {
            count.add(nums[i]);
        }
        for (int num : count) { 
        if (!count.contains(num - 1)) {  
            int c = 1;
            int curr = num;

            while (count.contains(curr + 1)) {
                curr++;
                c++;
            }

            maxLen = Math.max(maxLen, c);
        }
    }
        if(nums.length==0)
        {
            return 0;
        }
        else{
            return maxLen;
        }
    }
}
