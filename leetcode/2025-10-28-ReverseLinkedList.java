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
    public ListNode reverseByRecursion(ListNode temp,ListNode prev)
    {   
        if(temp==null) return prev;
        ListNode front = temp.next;
        temp.next = prev;

        return reverseByRecursion(front,temp);

       
    }
    public ListNode reverseList(ListNode head) {
        // Iterative approach 
        /*ListNode prev = null;
        ListNode temp = head;
        while(temp!=null)
        {
            ListNode front = temp.next;
            temp.next = prev;

            prev=temp;
            temp=front;
            
        }
        head = prev;
        return head;*/



        // Recursive Approach 
        return reverseByRecursion(head,null);
    }
}
