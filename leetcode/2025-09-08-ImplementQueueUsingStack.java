class MyQueue {
    Stack<Integer> st = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while(!st.empty()) // st ko khali kro 
        {
            temp.push(st.pop());
        }
        temp.push(x);
        while(!temp.empty())
        {
            st.push(temp.pop());
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
