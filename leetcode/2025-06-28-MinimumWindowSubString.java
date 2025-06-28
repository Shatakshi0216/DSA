class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for(int i=0;i<t.length();i++)
        {
            hash[t.charAt(i)]++;
        }
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        int cnt = 0;

        while(r<s.length())
        {
            char ch = s.charAt(r);
            hash[ch]--;

            if(hash[ch]>=0) cnt++;

            while(cnt==t.length())
            {
                if(r-l+1<minLen)
                {
                    minLen = r-l+1;
                    startIdx = l;
                } 

                hash[s.charAt(l)]++;

                if (hash[s.charAt(l)] > 0) {
                    cnt--;
                }

                l++; 
            }
            r++;
        }
         return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
