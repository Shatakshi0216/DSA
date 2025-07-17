class Solution {
    public int[] findNse(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            result[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return result;
    }

    public int[] findPse(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    public int largestAreaOfHistogram(int arr[]) {
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i] * (nse[i] - pse[i] - 1));
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            // Build histogram for current row
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') heights[j] += 1;
                else heights[j] = 0;
            }
            max = Math.max(max, largestAreaOfHistogram(heights));
        }
        return max;
    }
}
