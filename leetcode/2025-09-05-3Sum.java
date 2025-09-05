class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*int n = nums.length;
        
        Set<List<Integer>> set = new HashSet<List<Integer>>();
       
        for(int i=0;i<n;i++)
        {   
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int j=i+1;j<n;j++)
            {
                int val = -(nums[i]+nums[j]);
                if(hm.containsKey(val))
                {   
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    lst.add(val);
                    Collections.sort(lst);
                    set.add(lst);
                }
                hm.put(nums[j],1);
            }
            hm.clear();
        }
        List<List<Integer>> result = new ArrayList<>(set);
        return result;*/



        // OR 
        Arrays.sort(nums);
        List<List<Integer>> lst = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
            if(sum==0){
                lst.add(Arrays.asList(nums[i],nums[j],nums[k]));
                j++;
                k--;
                while(j<k && nums[j]==nums[j-1]) j++;
                while(j<k && nums[k]==nums[k+1]) k--;
            }
            else if(sum<0)
            {
                j++;
            }
            else
            {
                k--;
            }
        }
            
        
           
    }
        
        
        return lst;
    }
}
