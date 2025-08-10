class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            hash.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++)
        {
            
            int x = target - nums[i];
            if(hash.containsKey(x) && hash.get(x)!=i)
            {   
                
                return new int[] {i,hash.get(x)};
            }
        }
        return new int[] {-1,-1};
    }
}
