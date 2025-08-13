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
 class Data
 {
    int level;
    TreeNode node;
    Data(int l,TreeNode n)
    {
        level = l;
        node = n;
    }
 }
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Data> q = new LinkedList<>();
        HashMap<Integer,TreeNode> map = new HashMap<>();
        q.offer(new Data(1,root));
        while(!q.isEmpty())
        {
            Data curr = q.poll();
            if(!map.containsKey(curr.level)) 
            {
                map.put(curr.level,curr.node);
            }
            
            if(curr.node.right!=null) q.offer(new Data(curr.level+1,curr.node.right));
            if(curr.node.left!=null) q.offer(new Data(curr.level+1,curr.node.left));
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        
        Collections.sort(keys);
        for(int key : keys)
        {
            result.add(map.get(key).val);
        }
        return result;
    }
}
