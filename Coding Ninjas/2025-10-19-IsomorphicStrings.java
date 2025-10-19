import java.util.*;
public class Solution {
    public static boolean areIsomorphic(String str1, String str2) {
        // Write your code here.
        if(str1.length() != str2.length()) return false;
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str2.length();i++)
        {   
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(map.containsKey(c1))
            {
                if(map.get(c1)!=c2) return false;
            }
            else if(set.contains(c2)) return false;
            map.put(c1,c2);
            set.add(c2);
        }
        return true;
    }
}
