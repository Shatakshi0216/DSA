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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftHeight = 1;
        int rightHeight = 1;
        TreeNode temp = root;
        while(temp.left!=null)
        {
            leftHeight++;
            temp = temp.left;
        } 
        temp = root;
        while(temp.right!=null)
        {
            rightHeight++;
            temp = temp.right;
        } 
        if(leftHeight==rightHeight) return (int)Math.pow(2,leftHeight)-1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
