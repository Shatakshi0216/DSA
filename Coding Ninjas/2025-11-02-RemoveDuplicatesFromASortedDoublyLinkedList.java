/********************************************************

    Following is the class structure of the Node class:
    
    class Node
    {
        public:
            int data;
            Node next;
            Node(int data)
            {
                this.data = data;
                this.next = null;
            }
    };

********************************************************/

public class Solution {
    public static Node uniqueSortedList(Node head) {
        // Write your code here.
        if(head==null || head.next==null) return head; 
        Node prev = head;
        Node curr = head.next;
        while(curr!=null)
        {
            if(curr.data==prev.data)
            {
                   
                Node prevCurr = curr;
                prev.next = curr.next;
                curr = prevCurr.next;
                

            }
            else
            {
                curr = curr.next;
                prev = prev.next;
            }

        }
        return head;
    }
}
