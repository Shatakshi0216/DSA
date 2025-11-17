/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node reverseDLL(Node head)
    {
        // Write your code here.
        Node prevNode = null;
        Node curr = head;
        while(curr!=null)
        {
            Node nextPreserve = curr.next;
            curr.next = prevNode;
            if(prevNode!=null) prevNode.prev = curr;
            prevNode = curr;
            curr = nextPreserve;
        }
        return prevNode;
    }
}
