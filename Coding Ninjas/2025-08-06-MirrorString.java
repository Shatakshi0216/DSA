import java.util.* ;
import java.io.*; 
public class Solution {
    public static Boolean isReflectionEqual(String s) {
        // Write your code here.
        Set<Character> st = new HashSet<>(Arrays.asList('A','H','I','M','O','T','U','V','W','X','Y'));
        int n = s.length();
        for(int i=0;i<=n/2;i++)
        {
            char left = s.charAt(i);
            char right = s.charAt(n-i-1);

            if(left!=right || !st.contains(left)) return false;
        }
        return true;
    }
}
