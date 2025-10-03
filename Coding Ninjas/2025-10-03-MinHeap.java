import java.util.*;
import java.io.*; 

public class Solution {

    // minHeap function which takes size of Queries and Queries as Input.
    // Returns an array of outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (q[i][0] == 0) {
                // Insert into heap
                pq.offer(q[i][1]);
            } else if (q[i][0] == 1) {
                // Remove and return min element
                if (!pq.isEmpty()) {
                    result.add(pq.poll());
                }
            }
        }

        // Convert result ArrayList to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
