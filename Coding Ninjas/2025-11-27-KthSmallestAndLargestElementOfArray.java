import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        
        Collections.sort(arr);   // sort array
        
        int kthSmall = arr.get(k - 1);    // k-th smallest
        int kthLarge = arr.get(n - k);    // k-th largest
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(kthSmall);
        ans.add(kthLarge);
        
        return ans;
    }
}
