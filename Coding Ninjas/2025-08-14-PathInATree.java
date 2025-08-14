import java.util.* ;
import java.io.*; 
/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    static ArrayList<Integer> temp = new ArrayList<>();
    public static boolean helper(TreeNode node,int x)
    {
        if(node==null) return false;

        temp.add(node.data);

        if(node.data==x) return true;

        if(helper(node.left,x) || helper(node.right,x)) return true;

        temp.remove(temp.size()-1); // Backtracking 
        return false;
        
    }
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        // Write your code here..
        temp.clear(); // Clear before next time this function calls 
        helper(root,x);
        return temp;
    }
}
