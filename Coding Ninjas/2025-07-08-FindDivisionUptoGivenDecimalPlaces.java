import java.util.* ;
import java.io.*; 
public class Solution {
    public static String findDivision(int x, int y, int n) {
        // Write your code here.
        StringBuilder result = new StringBuilder();
        boolean negative = false;
        if((x>0 && y<0) || (x<0 && y>0)) negative = true;
        long numerator = Math.abs((long)x);
        long denominator = Math.abs((long)y);

        result.append(numerator/denominator);
        result.append(".");

        long remeinder = numerator%denominator;
        for(int i=1;i<=n;i++)
        {
            remeinder *= 10;
            result.append(remeinder/denominator);
            remeinder %= denominator;
        }

        if(negative && numerator!=0) result.insert(0,"-");
        return result.toString();

    }
}
