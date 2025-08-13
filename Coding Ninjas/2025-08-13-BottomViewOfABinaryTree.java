/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;
class Data
{
    int vertical;
    TreeNode node;
    Data(int v,TreeNode n)
    {
        vertical = v;
        node = n;
    }
}
public class Solution {
    public static List<Integer> bottomView(TreeNode root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Data> q = new LinkedList<>(); 
        HashMap<Integer,TreeNode> map = new HashMap<>(); 
        q.offer(new Data(0,root)); 
        while(!q.isEmpty())
        {   
            Data curr = q.poll();
            map.put(curr.vertical,curr.node);
            if(curr.node.left!=null) q.offer(new Data(curr.vertical-1,curr.node.left));
            if(curr.node.right!=null) q.offer(new Data(curr.vertical+1,curr.node.right));
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for(int key : keys)
        {
            result.add(map.get(key).val);
        }  
        return result;    
    }
}
