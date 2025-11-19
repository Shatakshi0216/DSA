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
 }

 *****************************************************************/

public class Solution
{
    public static Node segregateEvenOdd(Node head)
    {
        // Write Your Code Here.
        
        Node even = new Node(-1);
        Node odd = new Node(-1);
        Node oddHead = odd;
        Node evenHead = even;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data%2==0)
            {   
                even.next = temp;
                even = even.next;
            }
            else
            {
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
        }
        odd.next = null;
        even.next = oddHead.next;
        return evenHead.next;
    
        


    }
}
