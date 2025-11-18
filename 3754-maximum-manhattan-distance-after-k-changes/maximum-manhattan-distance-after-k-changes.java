class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0;     // current coordinates
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == 'N') y += 1;
            else if (c == 'S') y -= 1;
            else if (c == 'E') x += 1;
            else if (c == 'W') x -= 1;

            int m = i + 1;
            int d0 = Math.abs(x) + Math.abs(y);
            int changes = Math.min(k, m);
            int candidate = Math.min(m, d0 + 2 * changes);
            ans = Math.max(ans, candidate);
        }
        return ans;
    }
}
