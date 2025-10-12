class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);   
        }
        int sum = 0;
        for(Map.Entry<Integer,Integer> m : map.entrySet())
        {
            int key = m.getKey();
            int value = m.getValue();

            if(value%k==0)
            {
                sum += value*key;
            }
        }
        return sum;
    }
}
