class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String op : operations) {
            if (op.equals("D")) {
                st.push(2 * st.peek());
            } else if (op.equals("C")) {
                st.pop();
            } else if (op.equals("+")) {
                int top = st.pop();
                int newTop = top + st.peek();
                st.push(top); // put back first popped value
                st.push(newTop);
            } else {
                st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int num : st) {
            sum += num;
        }
        return sum;
    }
}
