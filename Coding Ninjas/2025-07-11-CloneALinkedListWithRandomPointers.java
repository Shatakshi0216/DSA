public class Solution {
    public static Node cloneLL(Node head) {
        if (head == null) return null;

        // Step 1: Clone nodes and insert in between
        Node curr = head;
        while (curr != null) {
            Node temp = new Node(curr.data);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }

        // Step 2: Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // Step 3: Separate the lists
        Node l1 = head;
        Node l2 = head.next;
        Node cloneHead = l2;

        while (l1 != null) {
            l1.next = l2.next;
            l1 = l1.next;
            if (l1 != null) {
                l2.next = l1.next;
                l2 = l2.next;
            }
        }

        return cloneHead;
    }
}
