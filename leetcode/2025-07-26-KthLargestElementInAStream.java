class KthLargest {
    int k;
    int nums[];
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums.clone();
        minHeap = new PriorityQueue<>();
        for(int x : nums)
        {
            minHeap.offer(x);
            if(minHeap.size()>k) minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll(); // Remove the smallest if size > k
        }
        return minHeap.peek(); // k-th largest element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
