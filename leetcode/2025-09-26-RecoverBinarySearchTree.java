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
    List<TreeNode> list = new ArrayList<>();
    public void inorder(TreeNode node)
    {   
        if(node==null) return;
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        TreeNode first = null;
        TreeNode second = null;
        for(int i=1;i<list.size();i++)
        {
            if(list.get(i).val<list.get(i-1).val)
            {
                if(first==null)
                {
                    first = list.get(i-1);
                }
                second = list.get(i);
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
