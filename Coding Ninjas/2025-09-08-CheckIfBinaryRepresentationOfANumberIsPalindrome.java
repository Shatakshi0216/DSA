import java.util.* ;
import java.io.*; 
public class Solution {

    public static boolean checkPalindrome(long N) {
        // Write your code here.
        String num = Long.toBinaryString(N);
        int i = 0;
        int j = num.length()-1;
        
        while(i<j)
        {
            if(num.charAt(i)!=num.charAt(j))
            {
                break;
            }
            i++;
            j--;
        }
        if(num.charAt(i)==num.charAt(j)) return true;
        else return false; 
    }

}
