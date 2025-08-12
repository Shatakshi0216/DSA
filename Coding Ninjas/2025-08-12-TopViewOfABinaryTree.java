/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;
class Data
{
    int line;
    TreeNode node;
    Data(int l,TreeNode n)
    {
        line = l;
        node = n;
    }
}
public class Solution {
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Data> q = new LinkedList<>();
        HashMap<Integer,TreeNode> map = new HashMap<>(); 

        q.offer(new Data(0,root));
        while(!q.isEmpty())
        {
            Data curr = q.poll();
            if(!map.containsKey(curr.line)) map.put(curr.line,curr.node);

            if (curr.node.left != null) q.offer(new Data(curr.line - 1, curr.node.left));
            if (curr.node.right != null) q.offer(new Data(curr.line + 1, curr.node.right));

        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(int k : keys)
        {
            result.add(map.get(k).data);
        }
        return result;
    }
}
