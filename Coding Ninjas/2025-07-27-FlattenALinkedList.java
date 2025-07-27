/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.child = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.child = null;
     }
     Node(int data, Node next, Node child)
     {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }

 *****************************************************************/

public class Solution {
    public static Node merge(Node l1,Node l2)
    {
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.data<l2.data)
            {
                curr.child = l1;
                l1 = l1.child;
                
            }
            else
            {
                curr.child = l2;
                l2 = l2.child;
                
            }
            curr = curr.child;
            curr.next = null;
        }
        if(l1!=null) curr.child = l1;
        if(l2!=null) curr.child = l2;

        return dummy.child;
    }
    public static Node mergedHead(Node head)
    {
        if(head==null || head.next==null) return head;
        Node flattenedNext = mergedHead(head.next);
        return merge(flattenedNext,head);
    }
    public static Node flattenLinkedList(Node head) {
        //Write your code here
        return mergedHead(head);

    }
}
