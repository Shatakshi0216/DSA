class Data {
    TreeNode node;
    long idx;
    Data(TreeNode n, long i) {
        node = n;
        idx = i;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Deque<Data> q = new ArrayDeque<>();
        q.offer(new Data(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            long start = q.peekFirst().idx;   // leftmost index in this level
            long end = q.peekLast().idx;      // rightmost index in this level
            maxWidth = Math.max(maxWidth, (int)(end - start + 1));

            for (int i = 0; i < size; i++) {
                Data curr = q.poll();

                if (curr.node.left != null)
                    q.offer(new Data(curr.node.left, 2 * curr.idx + 1));
                if (curr.node.right != null)
                    q.offer(new Data(curr.node.right, 2 * curr.idx + 2));
            }
        }

        return maxWidth;
    }
}
