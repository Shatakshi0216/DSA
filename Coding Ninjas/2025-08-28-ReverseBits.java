
public class Solution {
	public static long reverseBits(long n) {
		// Write your code here
		long result = 0;
		for(long shift = 31;shift>=0;shift--)
		{
			long bit = n & 1;
			result += (bit<<shift);
			n = n>>1;
		}
		return result;
	}

}
