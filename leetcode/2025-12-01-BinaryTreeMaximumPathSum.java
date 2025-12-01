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
    int maxSum = Integer.MIN_VALUE;
    public int maxVal(TreeNode node)
    {
        if(node==null) return 0;
        
        int left = Math.max(0,maxVal(node.left));
        int right = Math.max(0,maxVal(node.right));
        maxSum = Math.max(maxSum,node.val+left+right);
        return node.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        maxVal(root);
        return maxSum;
    }
}
