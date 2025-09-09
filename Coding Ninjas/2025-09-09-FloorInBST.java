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

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        TreeNode<Integer> temp = root;
        int result = -1;
        while(temp!=null)
        {
            if(temp.data<=X)
            {
                result = temp.data;
                temp = temp.right;
            }
            else 
            {
                temp = temp.left;
            }
        }
        return result;
    }
}
