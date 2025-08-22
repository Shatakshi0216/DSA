/**********************************************************
    Following is the Binary Tree Node class.

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }
***********************************************************/

public class Solution {
    // Helper function: LCA of two nodes
    private static BinaryTreeNode<Integer> lcaTwo(BinaryTreeNode<Integer> root, int n1, int n2) {
        if (root == null) return null;

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        BinaryTreeNode<Integer> left = lcaTwo(root.left, n1, n2);
        BinaryTreeNode<Integer> right = lcaTwo(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }

    // Main function: LCA of three nodes
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2, int node3) {
        // Step 1: LCA of first two nodes
        BinaryTreeNode<Integer> lca12 = lcaTwo(root, node1, node2);

        // Step 2: LCA of the result with third node
        BinaryTreeNode<Integer> lca123 = lcaTwo(root, lca12.data, node3);

        return lca123;
    }
}
