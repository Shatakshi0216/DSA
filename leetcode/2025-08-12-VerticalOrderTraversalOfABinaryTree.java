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

class VerticalOrder {
    TreeNode data;
    int row; // column index
    int col; // row index (depth)

    VerticalOrder(TreeNode d, int r, int c) {
        data = d;
        row = r;
        col = c;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // BFS queue
        Queue<VerticalOrder> q = new LinkedList<>();

        // Nested TreeMap: col -> (row -> min-heap of values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Start BFS from root at col=0, row=0
        q.offer(new VerticalOrder(root, 0, 0));

        while (!q.isEmpty()) {
            VerticalOrder nodeInfo = q.poll();
            TreeNode node = nodeInfo.data;
            int col = nodeInfo.row; // column index
            int row = nodeInfo.col; // row index

            // Put node in map
            map
                .computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new PriorityQueue<>())
                .offer(node.val);

            // Left child: col - 1, row + 1
            if (node.left != null) {
                q.offer(new VerticalOrder(node.left, col - 1, row + 1));
            }
            // Right child: col + 1, row + 1
            if (node.right != null) {
                q.offer(new VerticalOrder(node.right, col + 1, row + 1));
            }
        }

        // Build result from the map
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }
}
