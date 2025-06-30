import java.util.* ;
import java.io.*; 
public class Solution {
    public static String lookAndSaySequence(int n) {
        // Write your code here
        if(n==1) return "1";
        String term = "1";
        for(int i=2;i<=n;i++)
        {
            StringBuilder nextTerm = new StringBuilder();
            int count = 1;

            for(int j=1;j<term.length();j++)
            {
                if(term.charAt(j)==term.charAt(j-1)) count++;
                else
                {
                    nextTerm.append(count).append(term.charAt(j-1));
                    count = 1;
                } 
            }
            nextTerm.append(count).append(term.charAt(term.length()-1));
            term = nextTerm.toString();
        }
        return term;
    }
}
