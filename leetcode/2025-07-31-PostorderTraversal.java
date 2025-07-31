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

// Recursive 
// class Solution {
//     public void postOrder(TreeNode node,List<Integer> ans)
//     {
//         if(node==null) return;
//         postOrder(node.left,ans);
//         postOrder(node.right,ans);
//         ans.add(node.val);
//     }
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         postOrder(root,ans);
//         return ans;
//     }
// }


// Using 2 stacks 
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if(root==null) return ans;
//         TreeNode node = root;
//         Stack<TreeNode> st1 = new Stack<>();
//         Stack<TreeNode> st2 = new Stack<>();
//         st1.push(root);
//         while(!st1.isEmpty())
//         {
//             TreeNode curr = st1.pop();
//             st2.push(curr);
            
//             if(curr.left != null) st1.push(curr.left);
//             if(curr.right != null) st1.push(curr.right);
//         }
//         while(!st2.isEmpty()) ans.add(st2.pop().val);
//         return ans;
//     }
// }


// Using 1 stack 

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty())
        {
            TreeNode curr = st.pop();
            ans.add(curr.val);
            if(curr.left != null) st.push(curr.left);
            if(curr.right != null) st.push(curr.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}
