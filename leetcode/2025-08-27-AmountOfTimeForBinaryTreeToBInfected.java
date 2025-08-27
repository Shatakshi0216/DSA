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
    public int amountOfTime(TreeNode root, int start) {
        int time = 0;
        TreeNode startNode = new TreeNode();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // Finding node 
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr.val==start)
            {
                startNode = curr;
                break;
            }
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
        }

        // Marking parents 
        q.clear();
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr.left!=null)
            {
                q.offer(curr.left);
                parent.put(curr.left,curr);
            }
            if(curr.right!=null)
            {
                q.offer(curr.right);
                parent.put(curr.right,curr);
            }
        }

        // Finding injected 
        
        HashSet<TreeNode> visited = new HashSet<>();
        q.offer(startNode);
        visited.add(startNode);
        while(!q.isEmpty())
        {   
            int size = q.size();
            
            for(int i=0;i<size;i++)
            {   
                TreeNode curr = q.poll();
                if(curr.left!=null && !visited.contains(curr.left))
                {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right))
                {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                if(parent.containsKey(curr) && !visited.contains(parent.get(curr)))
                {
                    q.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                }
                
            }
            time++;
        }
        return time-1; // We added startNode but it is at time 0 
    }

}
