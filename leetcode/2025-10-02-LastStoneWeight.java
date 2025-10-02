class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++)
        {
            maxHeap.offer(stones[i]);
        }
        while(maxHeap.size()>1)
        {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first!=second)
            {
                maxHeap.offer(first-second);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
