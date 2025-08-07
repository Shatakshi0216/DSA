class Solution {
    public boolean sameTree(TreeNode i, TreeNode j) {
        if (i == null && j == null) return true;
        if (i == null || j == null) return false;

        if (i.val != j.val) return false;

        // Recursively check left and right subtrees
        return sameTree(i.left, j.left) && sameTree(i.right, j.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return sameTree(p, q);
    }
}
