/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };

 *****************************************************************/

public class Solution {
    public static Node reverse(Node start, Node end)
    {   
        Node prev = null;
        Node curr = start;
        Node stop = end.next;
        while(curr!=stop)
        {
            Node currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        
        return prev;


    }
    public static Node kReverse(Node head, int k) {
        // Write your code here.
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prevBlock = dummy;

        Node start = head;

        while(start!=null)
        {
            Node end = start;
            int count = 1;
            while(count<k && end!=null)
            {
                end = end.next;
                count++;
            }

            if(end==null) break;
            Node nextBlock = end.next;
            Node newHead = reverse(start,end);
            prevBlock.next = newHead;
            start.next = nextBlock;
            prevBlock = start;
            start = nextBlock;
        }
        return dummy.next;
    }
}
