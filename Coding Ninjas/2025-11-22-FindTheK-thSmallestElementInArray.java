import java.util.* ;
import java.io.*; 
public class Solution {
    public static int kthSmallest(ArrayList<Integer> v, int n, int k) {
        // Write your code here.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++)
        {
            maxHeap.offer(v.get(i));
            if(maxHeap.size()>k) maxHeap.poll();
        }
        return maxHeap.poll();
    }
}
