import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.*;

public class Solution {
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = q.poll();

                // The first node in this level is part of the left view
                if (i == 0) ans.add(node.data);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return ans;
    }
}

