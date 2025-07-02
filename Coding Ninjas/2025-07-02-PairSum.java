import java.io.*;
import java.util.*;

public class Solution {
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Go through keys only once
        Set<Integer> visited = new HashSet<>();

        for (int num : arr) {
            int complement = s - num;

            if (map.containsKey(complement) && map.containsKey(num)
                    && !visited.contains(num) && !visited.contains(complement)) {

                int countNum = map.get(num);
                int countComp = map.get(complement);

                if (num == complement) {
                    // Pairing number with itself
                    int pairs = (countNum * (countNum - 1)) / 2;
                    for (int i = 0; i < pairs; i++) {
                        result.add(new int[] {num, num});
                    }
                } else {
                    // Pairing two different numbers
                    int pairs = countNum * countComp; // Total cross-pairs
                    int a = Math.min(num, complement);
                    int b = Math.max(num, complement);
                    for (int i = 0; i < pairs; i++) {
                        result.add(new int[] {a, b});
                    }
                }

                visited.add(num);
                visited.add(complement);
            }
        }

        // Sort the result
        result.sort(Comparator.comparingInt((int[] a) -> a[0])
                              .thenComparingInt(a -> a[1]));

        return result;
    }
}
