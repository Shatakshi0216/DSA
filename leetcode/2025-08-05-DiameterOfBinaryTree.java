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
    int longest = 0;
    public int longestLength(TreeNode node)
    {
        if(node==null) return 0;
        int left = longestLength(node.left); 
        int right = longestLength(node.right); 
        longest = Math.max(longest,left+right);
        return 1+Math.max(left,right);
        
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        longestLength(root);
        return longest;
    }
}
