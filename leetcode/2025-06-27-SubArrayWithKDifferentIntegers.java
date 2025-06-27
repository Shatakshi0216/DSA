class Solution {
    public int atMostK(int[] nums, int k) {
        int l = 0, r = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            result += r - l + 1;
        }

        return result;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
}
