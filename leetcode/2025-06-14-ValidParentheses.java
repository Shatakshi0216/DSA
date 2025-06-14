class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') // open brackets
            {
                st.push(s.charAt(i));
            }
            else if(st.isEmpty() || (s.charAt(i)==')' && st.peek()!='(') || (s.charAt(i)==']' && st.peek()!='[') || (s.charAt(i)=='}' && st.peek()!='{'))   // if not same close or if stack is empty we direclty encounter a close bracket 
            
            {
                return false;
            }
            else
            {
                st.pop();  // if matches
            }
        
        }    
        return st.isEmpty();  
    }
}
