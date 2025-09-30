import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

class Solution {
    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        if (head == null || n == 0) return head;

        Node dummy = new Node(0); // helps manage head changes
        dummy.next = head;

        Node prevTail = dummy; // last node of previous processed block
        Node curr = head;      // current block head pointer

        for (int i = 0; i < n && curr != null; i++) {
            int k = b[i];

            if (k == 0) continue; // skip empty block

            // check how many nodes remain
            int count = 0;
            Node temp = curr;
            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }

            if (count < k) { 
                // less nodes remain than k ? reverse all and stop
                Node[] reversed = reverseBlock(curr, count);
                prevTail.next = reversed[0];
                reversed[1].next = temp;
                break; 
            }

            // reverse exactly k nodes
            Node[] reversed = reverseBlock(curr, k);
            prevTail.next = reversed[0]; // connect with prev block
            prevTail = reversed[1];      // update tail
            curr = reversed[1].next;     // move to next block
        }

        return dummy.next;
    }

    // helper to reverse k nodes from "head"
    // returns [newHead, newTail]
    private static Node[] reverseBlock(Node head, int k) {
        Node prev = null;
        Node curr = head;

        while (k > 0 && curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            k--;
        }

        head.next = curr; // old head becomes tail ? point to next part
        return new Node[]{prev, head}; // prev = newHead, head = newTail
    }
}
