/*******************************************************
    Following is the Binary Tree Node class structure.
    class BinaryTreeNode<T> {
      T data;
      BinaryTreeNode<T> left;
      BinaryTreeNode<T> right;
      
      public BinaryTreeNode(T data) {
        this.data = data;
      }
    }
*******************************************************/

public class Solution {
    public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
        // Base case: if tree is empty
        if (root == null) return 0;

        // If both left and right are null, it's a leaf node
        if (root.left == null && root.right == null)
            return 1;

        // Otherwise, count in left and right subtrees
        int leftLeaves = noOfLeafNodes(root.left);
        int rightLeaves = noOfLeafNodes(root.right);

        return leftLeaves + rightLeaves;
    }
}

