class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxFre = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFre = Math.max(maxFre, map.get(s.charAt(r)));

            if ((r - l + 1) - maxFre > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}