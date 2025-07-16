class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Sum of array 
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }

        int sumNNaturalNo = (n*(n+1))/2;

        int ans = sumNNaturalNo - sum;
        return ans;
    }
}
