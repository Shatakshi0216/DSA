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
    List<Integer> lst = new ArrayList<>();
    public void inorder(TreeNode node)
    {       
        if(node==null) return;
        inorder(node.left);
        lst.add(node.val);
        inorder(node.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int i = 0;
        int j = lst.size()-1;
        while(i<j)
        {   
            int sum = lst.get(i)+lst.get(j);
            if(sum==k) return true;
            else if(sum>k) j--;
            else i++;
        }
        return false;
        
    }
}
