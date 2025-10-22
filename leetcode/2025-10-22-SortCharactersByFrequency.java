class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>(); // Store frequency 
        
        for(int i=0;i<s.length();i++) map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1); // Add elements in map 


        // For max element at top 
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());    
        maxHeap.addAll(map.entrySet()); // Add all elements in heap from map 
        StringBuilder sb = new StringBuilder(); // Store result 
        while(!maxHeap.isEmpty())
        {
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int fre = entry.getValue();

            for(int i=0;i<fre;i++) sb.append(ch);
        }
        return sb.toString();
    }
}
