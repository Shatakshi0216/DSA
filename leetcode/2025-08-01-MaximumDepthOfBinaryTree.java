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
    public int depth(TreeNode node,int level)
    {   
        if(node==null) return 0;
        if(node.left == null && node.right==null)
        {
           return level;
        } 
        int leftDepth =  depth(node.left,level+1);
        int rightDepth =  depth(node.right,level+1);
        return Math.max(leftDepth,rightDepth);
    }
    public int maxDepth(TreeNode root) {
        return depth(root,1);
    }
}
