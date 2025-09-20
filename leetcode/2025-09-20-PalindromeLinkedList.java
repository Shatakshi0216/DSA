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
    public ListNode reverse(ListNode head,ListNode prev)
    {   
        if(head==null) return prev;
        ListNode front = head.next;
        head.next = prev;

        return reverse(front,head);
    }
    public boolean isPalindrome(ListNode head) {
        // Finding 1st and 2nd halfs 
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next,null);
        ListNode firstHead = head;
        ListNode secondHead = newHead;
        while(secondHead!=null)
        {
            if(firstHead.val!=secondHead.val) return false;
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }
}
