import java.util.* ;
import java.io.*; 

/************************************************************
    Following is the TreeNode class structure (provided by platform)

    class TreeNode<T> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

************************************************************/

public class Solution {
    // global variable to store the maximum path sum found so far
    private static int maxSum;

    public static int maxPathSum(TreeNode<Integer> root) {
        // initialize to smallest possible so negative-only trees are handled
        maxSum = Integer.MIN_VALUE;
        if (root == null) return 0; // if problem expects 0 for empty tree; adjust if needed
        dfs(root);
        return maxSum;
    }

    // returns maximum gain from this node to any one of its children
    private static int dfs(TreeNode<Integer> node) {
        if (node == null) return 0;

        // max gain from left and right (if negative, treat as 0 because we can skip that side)
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // price of a new path that passes through this node (could use both children)
        int priceNewPath = node.val + leftGain + rightGain;

        // update global maximum path sum
        maxSum = Math.max(maxSum, priceNewPath);

        // return to parent the max gain that this node can contribute (node + one side)
        return node.val + Math.max(leftGain, rightGain);
    }
}
