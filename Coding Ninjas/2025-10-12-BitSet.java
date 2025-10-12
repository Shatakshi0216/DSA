import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findFirstRepeatingDigit(String digitPattern) {
        // Write your code here.
        HashSet<Character> seen = new HashSet<>();
        for(char c : digitPattern.toCharArray())
        {
            if(seen.contains(c)) return c-'0';
            seen.add(c);
        }
        return -1;
    }
}
