import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            
            while(k > 0 && !st.isEmpty() && st.peek() > ch) {
                st.pop();
                k--;
            }
            
            st.push(ch);
        }
        
        // Remove remaining k if any
        while(k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        
        // Build result
        StringBuilder sb = new StringBuilder();
        for(char c : st) sb.append(c);
        
        // Remove leading zeros
        while(sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
