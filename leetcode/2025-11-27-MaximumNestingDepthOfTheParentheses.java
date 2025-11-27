class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int result = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            
            if(ch=='(') count++;
            else if(ch==')')count--;
            result = Math.max(result,count);

        }
        return result;
    }
}
