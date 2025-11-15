class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        // Create inc array which stores number of elements which are inc till now in sequence 
        int n = nums.size();
        int inc[] = new int[n];
        inc[0] = 1;
        for(int i=1;i<n;i++)
        {
            if(nums.get(i-1)<nums.get(i))
            {
                inc[i] = inc[i-1] + 1;
            }
            else
            {
                inc[i] = 1;
            }
        } 

        // We want to index 1st ending and 2nd ending 
        // 1st ending -> a+k-1 
        // 2nd ending -> a+2k-1

        // a -> each index we are talking for 
        for(int a=0; a+2*k<=n;a++)
        {
            int end1 = a+k-1;
            int end2 = a+2*k-1;

            if(inc[end1]>=k && inc[end2]>=k) return true;
        }
        return false;
    }
}
