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
    List<TreeNode> temp = new ArrayList<>();
    List<String> result = new ArrayList<>();
    public void helper(TreeNode node)
    {   
        if (node == null) return;
        temp.add(node);
        if(node.left==null && node.right==null)
        {   
            StringBuilder str = new StringBuilder();
            for(int i=0;i<temp.size();i++)
            {
                str.append(temp.get(i).val);
                if(i!=temp.size()-1) str.append("->");
            }
            result.add(str.toString());
        }
        else 
        {
            helper(node.left);
            helper(node.right);
        }
        temp.remove(temp.size() - 1); // Remove last element 
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root);
        return result;
        
    }
}
