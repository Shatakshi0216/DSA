import java.util.ArrayList;
public class Solution {
    public static int max(ArrayList<Integer> arr)
    {
        int max = arr.get(0);
        for(int i=1;i<arr.size();i++)
        {
            if(arr.get(i)>max) max=arr.get(i);

        }
        return max;
    }
    public static int sum(ArrayList<Integer> arr)
    {
        int sum = 0;
        for(int i=0;i<arr.size();i++)
        {
            sum += arr.get(i);

        }
        return sum;
    }
    public static int noOfStudent(ArrayList<Integer> arr,int pages)
    {   
        int student = 1;
        int pagesStudent = 0;

        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)+pagesStudent<=pages)
            {
                pagesStudent += arr.get(i);
            }
            else
            {
                student++;
                pagesStudent =arr.get(i);
            }
            
        }
        return student;
        
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.
        if(m>n) return -1;
        int low = max(arr);
        int high = sum(arr);
        

        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(noOfStudent(arr,mid)>m)
            {   
                low = mid+1;
                
            }
            else
            {
                high = mid-1;
            }
        }
        return low;
    }
}
