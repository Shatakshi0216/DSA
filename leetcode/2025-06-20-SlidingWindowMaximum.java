class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> lst = new ArrayList<>();
        // Making 1st window 
        for(int i=0;i<k;i++)
        { 
            while((!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])) dq.removeLast();
            dq.addLast(i);
        }
        for(int i=k;i<nums.length;i++)
        {
            lst.add(nums[dq.peekFirst()]);
            // Remove elements which are not the part of window 
            while(!dq.isEmpty() && dq.peekFirst()<=i-k) dq.removeFirst();

            while((!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])) dq.removeLast();
            dq.addLast(i);
        }
        lst.add(nums[dq.peekFirst()]); // Adding last max element 

        // Convert list into array 
        int result[] = new int[lst.size()];
        for(int i=0;i<lst.size();i++)
        {
            result[i] = lst.get(i);
        }
        return result;
    }
}
