class Solution {
    public int pivot(int arr[])
    {   
        int piv = -1;
        for(int i=arr.length-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
            {
                piv = i;
                break;
            }
        }
        return piv;
    }
    public void swap(int nums[],int a,int b)
    {
        int temp = nums[a];
         nums[a] =  nums[b];
        nums[b] = temp;
    }
    public void rightmost(int arr[],int piv)
    {
        for(int i=arr.length-1;i>piv;i--)
        {
            if(arr[i]>arr[piv])
            {
                swap(arr,i,piv);
                break;
            }
        }
    }
    public void reverse(int arr[],int piv)
    {
        int i=piv+1,j=arr.length-1;
        while(i<j)
        {
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        // Find pivot 
        int piv = pivot(nums); // Idx of pivot 
        if(piv==-1)
        {
            Arrays.sort(nums);
        }
        else
        {
            // find right most element than swap
        rightmost(nums,piv);
        // reverse from piv+1 to n-1
        reverse(nums,piv);
        }
       

    }
}
