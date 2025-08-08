import java.util.*;

public class Solution {
    static List<Integer> result = new ArrayList<>();

    public static void addLeftBoundary(TreeNode node) {   
        while (node != null) {
            if (node.left != null) {
                result.add(node.data);
                node = node.left;
            } else if (node.right != null) {
                result.add(node.data);
                node = node.right;
            } else break; // leaf node, stop
        }
    }

    public static void addRightBoundary(TreeNode node) {   
        Stack<Integer> st = new Stack<>();
        while (node != null) {
            if (node.right != null) {
                st.push(node.data);
                node = node.right;
            } else if (node.left != null) {
                st.push(node.data);
                node = node.left;
            } else break; // leaf node, stop
        }
        while (!st.isEmpty()) {
            result.add(st.pop());
        }
    }

    public static void addLeafNode(TreeNode node) {   
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(node.data);
            return;
        }
        addLeafNode(node.left);
        addLeafNode(node.right);
    }

    public static List<Integer> traverseBoundary(TreeNode root) {
        if (root == null) return result;

        result.add(root.data); // add root first

        if (root.left != null) {
            addLeftBoundary(root.left); 
        }

        addLeafNode(root);

        if (root.right != null) {
            addRightBoundary(root.right);
        }

        return result;
    }
}
