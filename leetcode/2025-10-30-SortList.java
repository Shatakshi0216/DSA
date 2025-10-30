/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode merge(ListNode firstHead, ListNode secondHead) {
        // Dummy node to build merged list
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (firstHead != null && secondHead != null) {
            if (firstHead.val < secondHead.val) {
                temp.next = firstHead;
                firstHead = firstHead.next;
            } else {
                temp.next = secondHead;
                secondHead = secondHead.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (firstHead != null) temp.next = firstHead;
        if (secondHead != null) temp.next = secondHead;

        return dummy.next;  // Return actual head
    }

    public ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode midNode = mid(head);
        ListNode firstHead = head;
        ListNode secondHead = midNode.next;
        midNode.next = null;

        firstHead = mergeSort(firstHead);
        secondHead = mergeSort(secondHead);

        return merge(firstHead, secondHead);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
