import java.util.* ;
import java.io.*; 

/*
    Definition of Node class for reference

    class TreeNode<T> 
    {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
*/

public class Solution {

    static class BSTIterator {
        Stack<TreeNode<Integer>> st = new Stack<>();

        // Constructor
        BSTIterator(TreeNode<Integer> root) {
            pushAllLeft(root);
        }

        // Function to get next smallest value
        int next() {
            TreeNode<Integer> node = st.pop();
            // After visiting node, go right and push all left children of that right subtree
            pushAllLeft(node.right);
            return node.data;
        }

        // Function to check if any next node exists
        boolean hasNext() {
            return !st.isEmpty();
        }

        // Helper function to push all left nodes into stack
        private void pushAllLeft(TreeNode<Integer> node) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
        }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
