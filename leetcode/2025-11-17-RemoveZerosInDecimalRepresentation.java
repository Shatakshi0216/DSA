class Solution {
    public long reverse(long num)
    {   
        long newNum = 0;
        while(num>0)
        {
            long rem = num%10;
            newNum = newNum*10 + rem;
            num = num/10;
        }
        return newNum;
    }
    public long removeZeros(long n) {
        long m = n;
        long result = 0;
        while(m>0)
        {
            long rem = m%10;
            if(rem!=0)
            {
                result = result*10 + rem;
            }
            m = m/10;
        }
        long reversed = reverse(result);
        return reversed;
    }
}
