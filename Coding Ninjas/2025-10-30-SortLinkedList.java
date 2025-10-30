import java.util.* ;
import java.io.*; 
/*************************************************************

	Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

public class Solution {
    public static Node sortLL(Node head) {
        // Edge case: empty or single node
        if (head == null || head.next == null) return head;

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            // If the current node has negative data, move it to front
            if (curr.data < 0) {
                prev.next = curr.next; // unlink current
                curr.next = head;      // move to front
                head = curr;           // update head
                curr = prev.next;      // move to next node after prev
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}
