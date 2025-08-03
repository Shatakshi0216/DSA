import java.util.*;
public class Solution {
    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        // Largest 
        int max = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i]>max)
            {
                max = a[i];
                result.add(a[i]);
            }
        }
        return result;

    }    
}
