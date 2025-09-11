/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode findLastRight(TreeNode root)
    {
        while(root.right!=null) root = root.right;
        return root;
    }
    public TreeNode helper(TreeNode root, int key)
    {
        // For only one or no child 
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left; // We need to return left portion 
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null; // root is null
        if(root.val==key) return helper(root,key); // When root is the key
        TreeNode StoredRoot = root; // we are storing root
        while(root!=null) // For finding the child than remaining depends upon helper 
        {
            if(root.val>key) // left 
            {
                if(root.left!=null && root.left.val==key) // left is equal to k
                {
                    root.left = helper(root.left,key); // this will return left portion 
                    break;
                }
                else 
                {
                    root = root.left; // Simply move to left 
                }
            }
            else 
            {
                if(root.right!=null && root.right.val==key) // right is equal to k
                {
                    root.right = helper(root.right,key); // this will return right portion 
                    break;
                }
                else 
                {
                    root = root.right; // Simply move to right 
                }
            }
        }
        return StoredRoot;
    }
}
