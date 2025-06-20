public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		long maxSum = 0;
		long currSum = 0;

		for (int i = 0; i < n; i++) {
			currSum = currSum + arr[i];

			if (currSum < 0) {
				currSum = 0;
			}

			maxSum = Math.max(maxSum, currSum);
		}

		return maxSum;
	}
}
