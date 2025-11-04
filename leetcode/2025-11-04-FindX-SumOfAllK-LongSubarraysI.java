class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        for(int i=0;i<=n-k;i++) // n = 6 k = 3 -> 3 
        {
            HashMap<Integer,Integer> map = new HashMap<>(); 
            for(int j=i;j<i+k;j++) // k = 3 i = 0 => 0 to 3 : k = 3 i = 1 => 1 to 4 
            {
                map.put(nums[j],map.getOrDefault(nums[j],0)+1); // Putting elements with their frequencies
            }
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return b[0]-a[0]; 
            else return b[1]-a[1];
            });
            // first check for same fre if same compare with values

            // Add elements in priority queue
            for(int key : map.keySet())
            {
                maxHeap.offer(new int[] {key,map.get(key)});
            }  
            int count = x;
            int sum = 0;
            while(count-- > 0 && !maxHeap.isEmpty())
            {
                int[] top = maxHeap.poll(); // Extract top k elements 
                sum += top[0] * top[1]; // value * frequency
            }
            ans[i] = sum;
        }
        return ans;
    }
}
