import java.util.*;

public class Solution {
    public static int[] kMaxSumCombination(int[] a, int[] b, int n, int k) {
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        Set<String> visited = new HashSet<>();

        int i = n - 1;
        int j = n - 1;
        maxHeap.offer(new int[]{a[i] + b[j], i, j});
        visited.add(i + "#" + j);

        int[] result = new int[k];
        int index = 0;

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int sum = current[0], x = current[1], y = current[2];
            result[index++] = sum;

            // (x-1, y)
            if (x - 1 >= 0) {
                String key = (x - 1) + "#" + y;
                if (!visited.contains(key)) {
                    maxHeap.offer(new int[]{a[x - 1] + b[y], x - 1, y});
                    visited.add(key);
                }
            }

            // (x, y-1)
            if (y - 1 >= 0) {
                String key = x + "#" + (y - 1);
                if (!visited.contains(key)) {
                    maxHeap.offer(new int[]{a[x] + b[y - 1], x, y - 1});
                    visited.add(key);
                }
            }
        }

        return result;
    }
}
