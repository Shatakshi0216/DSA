class Solution {
    public int reverse(int x) {
        if(x<0)
        {
            int neg = Math.abs(x);
            int rem = 0;
            int result = 0;
            while(neg!=0)
            {
                rem = neg%10;
                neg = neg/10;
                if(result>Integer.MAX_VALUE/10 || result<Integer.MIN_VALUE/10)
                {
                    return 0;
                }
                result = result*10 + rem;
            }
            return -result;
            
           
        }
        else
        {
            int rem = 0;
            int result = 0;
            while(x!=0)
            {
                rem = x%10;
                x = x/10;
                if(result>Integer.MAX_VALUE/10 || result<Integer.MIN_VALUE/10)
                {
                    return 0;
                }
                result = result*10 + rem;
            }
            return result;
        }
        
        
    }
}
