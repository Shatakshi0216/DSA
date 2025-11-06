import java.util.* ;
import java.io.*; 
public class Solution 
{   
    public static boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;

        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public static int countNumberOfPalindromeWords(String s) 
	{
        // Write your code here!
        int count = 0;
        String seperated[] = s.split("\\s+"); // Split by any whitespace 
        for(String word : seperated)
        {
            word = word.replaceAll("[^a-zA-Z]","").toLowerCase();
            if(!word.isEmpty() && isPalindrome(word)) count++;
        }
        return count;
    }
}
