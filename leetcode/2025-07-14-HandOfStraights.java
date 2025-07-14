class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0) return false;
        

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : hand)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.keySet());
        
    
        while(!minHeap.isEmpty())
        {   
            int first = minHeap.peek();
            for(int i=0;i<groupSize;i++)
            {
                int card = first+i;
                if(!map.containsKey(card)) return false;

                map.put(card,map.get(card)-1);
                if(map.get(card)==0) 
                {
                    map.remove(card);
                    minHeap.remove(card);
                }
            }
        }
        return true;
    }
}
