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
    public static void remove(Node temp,Node prev)
    {
        prev.next = temp.next;
    }
    public static Node uniqueSortedList(Node head) {
        // Write your code here.
        if(head==null) return null;
        
        if(head.next==null) return head;
        Node temp = head.next;
        Node prev = head;
        while(temp!=null)
        {
            if(prev.data==temp.data)
            {
                remove(temp,prev);
            } 
            else
            {
                prev = prev.next;
            }
            temp = temp.next;
            
        }
        return head;
    }

}
