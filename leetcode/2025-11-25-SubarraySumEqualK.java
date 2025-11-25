import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // key -> prefix sum, value -> count
        hm.put(0, 1);  // (0,1): to handle the case when a prefix sum equals k

        int prefSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefSum += nums[i];
            int remove = prefSum - k;

            // If the hashmap contains remove, it means there's a subarray sum equals k
            if (hm.containsKey(remove)) {
                count += hm.get(remove);
            }

            // Update the count of current prefix sum in the map
            hm.put(prefSum, hm.getOrDefault(prefSum, 0) + 1);
        }

        return count;
    }
}
