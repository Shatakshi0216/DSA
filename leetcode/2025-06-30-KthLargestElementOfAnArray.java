import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);  // ✅ Use add() instead of insert()

            if (minHeap.size() > k) {
                minHeap.poll();    // ✅ Remove the smallest (top) if size > k
            }
        }

        return minHeap.peek(); // ✅ Top of min-heap is the kth largest
    }
}
