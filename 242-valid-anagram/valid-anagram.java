class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }
        char s1[] = s.toCharArray();
        char t1[] = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        s = String.valueOf(s1);
        t = String.valueOf(t1);

        if(s.compareTo(t)==0)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}