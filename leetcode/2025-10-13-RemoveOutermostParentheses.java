class Solution {
    public String removeOuterParentheses(String s) {
        int level = 0;
        StringBuilder result = new StringBuilder(); 
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(level > 0) result.append('(');
                level++;
            }
            if(ch == ')') {
                level--;
                if(level > 0) result.append(')');
                
            }
        }
        return result.toString();
    }
}
