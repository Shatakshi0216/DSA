from collections import defaultdict
from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        curr_sum = 0
        prefix_map = defaultdict(int)
        prefix_map[0] = 1   # base case: subarray starting from index 0
        
        for num in nums:
            curr_sum += num
            
            # check if (curr_sum - k) has appeared before
            if (curr_sum - k) in prefix_map:
                count += prefix_map[curr_sum - k]
            
            # store current prefix sum frequency
            prefix_map[curr_sum] += 1
        
        return count
