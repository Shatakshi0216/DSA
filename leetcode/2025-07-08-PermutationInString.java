class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int cnt = 0;
        int[] hash = new int[256];

        for(int i=0;i<s1.length();i++)
        {
            hash[s1.charAt(i)]++;
        }

        int l = 0;
        int r = 0;
        while(r<s2.length())
        {
            char ch = s2.charAt(r);
            hash[ch]--;

            if(hash[ch]>=0) cnt++;
            if(r-l+1>s1.length())
            {   
                char leftChar = s2.charAt(l);
                if(hash[leftChar]>=0) cnt--;
                hash[leftChar]++;
                l++;
            } 

            if(cnt==s1.length()) return true;
            r++;
        }
        return false;
    }
}
