class Solution {
    public int[] findNSE(int[] arr) {
        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] findPSEE(int[] arr) {
        int[] psee = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        long sum = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 0; i < arr.length; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;
            sum = (sum + (left * right % mod) * arr[i] % mod) % mod;
        }

        return (int) sum;
    }
}
