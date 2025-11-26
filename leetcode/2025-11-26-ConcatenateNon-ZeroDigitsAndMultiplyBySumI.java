class Solution {
    public long sumAndMultiply(int n) {
        // handle negative input
        int m = Math.abs(n);

        StringBuffer sb = new StringBuffer();
        while (m != 0) {
            int rem = m % 10;
            if (rem != 0) sb.append(rem); // skip zeros
            m = m / 10;
        }

        // If sb is empty (happens when original n was 0), return 0
        if (sb.length() == 0) return 0L;

        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            sum += sb.charAt(i) - '0';
        }

        sb.reverse();
        String s = sb.toString();

        long formed = Long.parseLong(s);
        return formed * (long) sum;
    }
}
