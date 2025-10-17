import java.util.*;

public class Solution {
    public static int findMaxFruits(int[] arr, int n) {
        int left = 0;
        int maxFruits = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int fruit = arr[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            // If more than 2 fruit types, shrink window from left
            while (map.size() > 2) {
                int leftFruit = arr[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                left++;
            }

            // Update maximum length
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
