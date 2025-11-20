import java.util.*;
public class Solution 
{
    public static int timeTakenToMail(String keyboard, String s)
    {
        // Write your code here.
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<keyboard.length();i++)
        {
            map.put(keyboard.charAt(i),i);
        }
        int prev = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            int curr = map.get(ch);
            count += Math.abs(curr-prev);
            prev = curr;
        }
        return count;
    }
}
