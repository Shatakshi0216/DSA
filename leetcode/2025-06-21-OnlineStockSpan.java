import java.util.Stack;

class StockSpanner {
    Stack<int[]> st = new Stack<>();
    int idx;

    public StockSpanner() {
        idx = -1;
        st.clear();
    }

    public int next(int price) {
        idx = idx + 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        int span = idx - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[]{price, idx});
        return span;
    }
}
