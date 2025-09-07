class Solution {
    public String expand(String s,int l,int r)
    {
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }
        return s.substring(l+1,r); // When this while condition gets break l will move one step behind 
    }
    public String longestPalindrome(String s) {
      String lps = "";
      int left=0 , right=0;
      if(s.length()==0 || s==null)
      {
        return "";
      }  
      for(int i=0;i<s.length();i++)
      {
        // If string is odd 
        String oddPalindrome = expand(s,i,i);
        if(oddPalindrome.length()>lps.length())
        {
            lps = oddPalindrome;
        }

        // If string is even 
        String evenPalindrome = expand(s,i,i+1);
        if(evenPalindrome.length()>lps.length())
        {
            lps = evenPalindrome;
        }
      }
      return lps;  
    }
}
