/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.*;

public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        traverse(root, inorder, preorder, postorder);

        List<List<Integer>> result = new ArrayList<>();
        result.add(inorder);
        result.add(preorder);
        result.add(postorder);

        return result;
    }

    private static void traverse(TreeNode node, List<Integer> inorder, List<Integer> preorder, List<Integer> postorder) {
        if (node == null) return;

        preorder.add(node.data);                  // Preorder: Root
        traverse(node.left, inorder, preorder, postorder);  // Left
        inorder.add(node.data);                   // Inorder: Root (after Left)
        traverse(node.right, inorder, preorder, postorder); // Right
        postorder.add(node.data);                 // Postorder: Root (after Left+Right)
    }
}
