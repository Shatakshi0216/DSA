import java.util.*;
public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        if(n==1) return a;
        Arrays.sort(a);
        if(n==2) return new int[] {a[0],a[1]}; 
        int secondSmallest = a[1];
        int secondLargest = a[n-2];
        return new int[] {secondLargest,secondSmallest}; 
    }
}
