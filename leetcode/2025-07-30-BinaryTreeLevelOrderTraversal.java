import java.util.*;

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans; // base case: empty tree

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // start with root

        while (!q.isEmpty()) {
            int levelSize = q.size(); // number of nodes at current level
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                subList.add(current.val);

                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }

            ans.add(subList); // add current level values to final result
        }

        return ans;
    }
}
