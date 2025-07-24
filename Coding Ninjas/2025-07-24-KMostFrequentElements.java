import java.util.*;
public class Solution {
    public static int[] KMostFrequent(int n, int k, int[] arr) {
        // Write your code here.
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : arr)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) -> a.getValue() - b.getValue()
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k) pq.poll();
        }
        int result[] = new int[k];
        for(int i=0;i<k;i++)
        {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
