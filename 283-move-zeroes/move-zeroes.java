class Solution {
    public void moveZeroes(int[] nums) {
        int n= nums.length;
        int j= -1;
        for(int k=0;k<n;k++)
        {
            if(nums[k]==0)
            {
                j=k;
                break;
            }
        }
        if(j==-1)
        {
            return;
        }
        int i = j+1;
        while(i<n)
        {
            
            if(nums[i]!=0)
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
                i++;
            }
            else
            {
                i++;
            }
        }
        

    }
}