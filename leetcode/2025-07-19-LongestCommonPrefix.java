import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*String ans = "";
        for(int i=0;i<strs[0].length();i++)
        {
            char ch = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if(i>=strs[j].length() || strs[j].charAt(i)!=ch) return ans;
            }

            ans += ch;
        }
        return ans;*/

        // Or 
         // 🔒 Check if input is null or empty → no common prefix possible
        if(strs.length==0 || strs==null) return "";

        // 🎯 Assume the first string is the common prefix initially
        String prefix = strs[0];

        // 🔁 Loop through all strings (should start from i = 1, not 0)
        for(int i=0;i<strs.length;i++)
        {
             // 🛑 While current string does NOT start with the prefix
            while(strs[i].indexOf(prefix) != 0)
            {   
                 // ✂️ Remove last character from prefix
                prefix = prefix.substring(0,prefix.length()-1);

                // ❌ If prefix becomes empty, no common prefix exists
                if(prefix.isEmpty()) return "";
            }
        }
        // ✅ Return the longest common prefix
        return prefix;
    }
}
