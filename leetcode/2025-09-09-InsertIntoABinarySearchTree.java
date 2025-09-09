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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root==null) return node;
        
        TreeNode temp = root;
        TreeNode prev = null;
        while(temp!=null)
        {   
             prev = temp;
            if(val>temp.val) temp = temp.right;
            else temp = temp.left;
           
        }
        if(val>prev.val) prev.right = node;
        else prev.left = node;
        return root;
    }
}
