import java.util.List;
import java.util.*;
public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Write your code here.
         List<Integer> result = new ArrayList<>();
        int[] coins = {1,2,5,10,20,50,100,500,1000};
        for(int i=coins.length-1;i>=0;i--)
        {
            while(n>=coins[i])
            {
                n = n-coins[i];
                result.add(coins[i]);
            } 
        }
        return result;
    }
}
