import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int maximumChocolates(ArrayList<Integer> arr,int k){
        // Write your code here.

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int num : arr) maxHeap.add(num);

        int chocolates = 0;

        while(k-->0 && !maxHeap.isEmpty())
        {
            int choco = maxHeap.poll();
            chocolates += choco;
            maxHeap.add(choco/2);
        }
        return chocolates;
    }
}
