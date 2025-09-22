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
    public static int predecessor(TreeNode root,int key)
    {
        int result = -1;
        while(root!=null)
        {
            if(root.data>=key)
            {
                root = root.left;
            }
            else 
            {
                result = root.data;
                root = root.right;
            }
        }
        return result;
    }
    public static int successor(TreeNode root,int key)
    {
        int result = -1;
        while(root!=null)
        {
            if(root.data<=key)
            {
                root = root.right;
            }
            else 
            {
                result = root.data;
                root = root.left;
            }
        }
        return result;
    }
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        result.add(predecessor(root,key));
        result.add(successor(root,key));
        return result;
    }
}
