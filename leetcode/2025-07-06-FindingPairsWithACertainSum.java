class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        map.put(oldVal, map.get(oldVal) - 1);
        if (map.get(oldVal) == 0) map.remove(oldVal);

        nums2[index] += val;
        int newVal = nums2[index];
        map.put(newVal, map.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int cnt = 0;
        for (int num : nums1) {
            int comp = tot - num;
            cnt += map.getOrDefault(comp, 0);
        }
        return cnt;
    }
}
