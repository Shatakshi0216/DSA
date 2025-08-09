class Solution {
    public boolean isPalindrome(int x) {
        int temp = 0;
        int m = x;
        if(x<0)
        {
            return false;
        }
        while(x!=0)
        {
            int rem = x%10;
            x = x/10;
            temp = temp*10 + rem;
        }
        if(temp==m)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
