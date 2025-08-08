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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> finalAns = new ArrayList<>();
        if(root==null) return finalAns;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        
        int level = 1;

        
        while(!dq.isEmpty())
        {   
            List<Integer> levelList = new ArrayList<>();
            int size = dq.size();
            
            for(int i=1;i<=size;i++)
            {   
                TreeNode node = dq.pollFirst();
                if(level%2==0)
                {
                    levelList.add(0,node.val);
                }
                else
                {
                    levelList.add(node.val);
                }
                if (node.left != null) dq.addLast(node.left);
                if (node.right != null) dq.addLast(node.right);
            }
            level++;
            finalAns.add(levelList);
        }
        return finalAns;
    }
}
