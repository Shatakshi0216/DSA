import java.util.* ;
import java.io.*; 
public class Solution {
    public static long titleToNumber(String str)
    {   
        long result = 0;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            int val = ch - 'A' + 1;
            result = result*26 + val; 
        }
        return result;
    }
}
