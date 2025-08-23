import java.util.* ;
import java.io.*; 

public class Solution {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Fix one element and find pair
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == K) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[j]);
                    triplet.add(arr[k]);
                    result.add(triplet);

                    // Skip duplicates for j and k
                    while (j < k && arr[j] == arr[j + 1]) j++;
                    while (j < k && arr[k] == arr[k - 1]) k--;

                    j++;
                    k--;
                } 
                else if (sum < K) {
                    j++;
                } 
                else {
                    k--;
                }
            }
        }

        return result;
    }
}
