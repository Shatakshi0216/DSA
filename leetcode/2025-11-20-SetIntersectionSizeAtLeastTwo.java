class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        // Sort by end ASC, and if equal, start DESC
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int x = -1, y = -1;   // last two chosen numbers
        int count = 0;

        for (int[] in : intervals) {
            int start = in[0];
            int end   = in[1];

            boolean xIn = (x >= start);
            boolean yIn = (y >= start);

            if (xIn && yIn) {
                // both already intersect → no need to add
                continue;
            }

            if (yIn) {
                // only y is inside → need to add one more
                count++;
                x = y;
                y = end;   // pick largest possible
            } 
            else {
                // neither is inside → need two numbers
                count += 2;
                x = end - 1;
                y = end;
            }
        }

        return count;
    }
}
