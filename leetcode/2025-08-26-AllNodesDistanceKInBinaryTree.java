/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Step 1: Build parent mapping using BFS
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        
        // Step 2: BFS from target, keeping track of distance
        List<Integer> result = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int distance = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k) { // collect all nodes at distance k
                for (int i = 0; i < size; i++) {
                    result.add(q.poll().val);
                }
                return result;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                // left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                // right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                // parent
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.offer(parent.get(curr));
                }
            }
            
            distance++;
        }
        
        return result;
    }
}
