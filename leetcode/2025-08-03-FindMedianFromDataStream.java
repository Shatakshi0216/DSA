import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    // Max heap stores the smaller half of the numbers
    PriorityQueue<Integer> maxHeap;
    
    // Min heap stores the larger half of the numbers
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // Max heap (reverse order for max heap functionality)
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Min heap (default behavior is min heap)
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add the number to maxHeap first (small half)
        maxHeap.offer(num);
        
        // Step 2: Move the largest number from maxHeap to minHeap
        // So that all elements in maxHeap are <= elements in minHeap
        minHeap.offer(maxHeap.poll());

        // Step 3: Balance the heaps (maxHeap can have 1 extra element at most)
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int totalSize = minHeap.size() + maxHeap.size();

        // If total number of elements is odd, return the top of maxHeap
        if (totalSize % 2 != 0) {
            return maxHeap.peek();
        } 
        // If total is even, return average of tops of both heaps
        else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
