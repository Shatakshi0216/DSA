import java.util.* ;
import java.io.*; 
import java.util.List;

public class Solution {
    
    public static int[] linearProbing(List<Integer> keys) {
        // Write your code here.
        int arr[] = new int[keys.size()*2];
        Arrays.fill(arr,-1);
        for(int i=0;i<keys.size();i++)
        {
            int index = keys.get(i)%keys.size();
            while(arr[index]!=-1)
            {
                index = (index+1)%keys.size();
            }
            arr[index] = keys.get(i);
            
        }
        return arr;
    }

}
