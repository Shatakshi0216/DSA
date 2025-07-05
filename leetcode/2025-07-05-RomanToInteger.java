class Solution {
    public int romanToInt(String s) {
        int i=0;
        int ans = 0;
        while(i<s.length())
        {
            char curr = s.charAt(i);
            int currVal = getValue(curr);

            if(i+1<s.length())
            {
                char next = s.charAt(i+1);
                int nextVal = getValue(next);

                if(currVal<nextVal)
                {
                    ans += nextVal - currVal;
                    i+=2;
                    continue;
                }
            }
            ans+=currVal;
            i++;
           
        }
         return ans;
    }

    public static int getValue(char convert)
    {
        switch(convert)
        {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
        
    }
}
