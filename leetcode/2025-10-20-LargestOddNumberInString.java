class Solution {
    public String largestOddNumber(String num) {
        
        
        int lastOddIdx = -1;
        // last odd number 
        for(int i=num.length()-1;i>=0;i--)
        {
            int n = num.charAt(i)-'0';
            if(n%2!=0)
            {
                lastOddIdx = i;
                break;
            }
        }
        if(lastOddIdx==-1) return "";
        return num.substring(0,lastOddIdx+1);
        
    }
}
