public class Solution {
  public static Node removeLoop(Node head) {
    if (head == null || head.next == null) return head;

    // Detect loop using Floyd's cycle-finding
    Node slow = head, fast = head;
    boolean hasCycle = false;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) { // meeting point
        hasCycle = true;
        break;
      }
    }

    if (!hasCycle) return head; // no loop

    // Find start of loop
    Node ptr1 = head;
    Node ptr2 = slow; // meeting point

    // Special case: cycle starts at head
    if (ptr1 == ptr2) {
      while (ptr2.next != ptr1) {
        ptr2 = ptr2.next;
      }
      // ptr2 is last node in the cycle
      ptr2.next = null;
      return head;
    }

    // General case: advance both until their next pointers match (node before loop start)
    while (ptr1.next != ptr2.next) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    // Break the cycle
    ptr2.next = null;
    return head;
  }
}
