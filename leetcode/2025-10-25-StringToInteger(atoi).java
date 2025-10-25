class Solution {
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        long result = 0;
        int sign = 1;
        int i = 0;
        while(i<s.length() && s.charAt(i)==' ') i++;
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-'))
        {
            if(s.charAt(i)=='-')
            {
                sign = -1;    
            } 
            i++;
        } 
        while(i<s.length() && Character.isDigit(s.charAt(i)))
        {
            int digit = s.charAt(i)-'0';
            result = result*10+digit;
            i++;

            if(sign*result >= Integer.MAX_VALUE)  return Integer.MAX_VALUE;
            if(sign*result <= Integer.MIN_VALUE) return Integer.MIN_VALUE; 
        }
          

        return (int)(sign*result);
    }
}
