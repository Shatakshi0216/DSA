class Solution {
    public void mergeSort(int arr[],int str,int mid,int end)
    {   
        int output[] = new int[end-str+1]; 
       
            int i = str;
            int j = mid+1;
            int k = 0;
            while(i<=mid && j<=end)
            {
                if(arr[i]<=arr[j])
                {
                    output[k++] = arr[i++];
                }
                else
                {
                    output[k++] = arr[j++];
                }
            }
            while(i<=mid)
            {
                output[k++] = arr[i++];
            }
            while(j<=end)
            {
                output[k++] = arr[j++];
            }
        for(int a=0;a<output.length;a++)
        {
            arr[str+a] = output[a];
        }
    }
    public void merge(int arr[],int str,int end)
    {
        if(str<end)
        {
            int mid = (str+end)/2;
            merge(arr,str,mid);
            merge(arr,mid+1,end);
            mergeSort(arr,str,mid,end);
        }
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        merge(nums,0,n-1);

        
    }
}
