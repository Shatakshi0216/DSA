/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     BinaryTreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     BinaryTreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/
class NodeInfo
{
    int size;
    int max;
    int min;
    NodeInfo(int s,int max,int min)
    {
        size = s;
        this.max = max;
        this.min = min;
    }
}
public class Solution {
    public static NodeInfo largestBSTSubreeHelper(TreeNode root)
    {
        if(root==null)
        {
            // An empty tree is BST with size 0
            return new NodeInfo(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

         
        NodeInfo left = largestBSTSubreeHelper(root.left);
        NodeInfo right = largestBSTSubreeHelper(root.right);

        if(left.max<root.data && right.min>root.data) return new NodeInfo(left.size+right.size+1,Math.max(root.data,right.max),Math.min(left.min,root.data));
        else 
        {
            return new NodeInfo(Math.max(left.size,right.size),Integer.MAX_VALUE,Integer.MIN_VALUE);
        }        
        
    }
    public static int largestBST(TreeNode root) {
        // Write your code here.
        NodeInfo result =  largestBSTSubreeHelper(root);
        return result.size;

    }
}
