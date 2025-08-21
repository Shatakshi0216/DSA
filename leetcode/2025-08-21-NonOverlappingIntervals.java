class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         if (intervals.length == 0) return 0;
        Arrays.sort(intervals , (a,b)->Integer.compare(a[1],b[1]));   // Compare last indexes
        int lastEnd = Integer.MIN_VALUE;
        int count = 0;
        for(int interval[] : intervals)  // intervals [0] = {1,2}
        {
            int str = interval [0];
            int end = interval [1];
            if(str>=lastEnd)
            {
                lastEnd = end;
            }
            else
            {
                count++;
            }
        }
        return count;
    }
}
