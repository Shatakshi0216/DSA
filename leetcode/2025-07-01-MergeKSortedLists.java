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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);

        for(int i=0;i<lists.length;i++)
        {
            if(lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(!minHeap.isEmpty())
        {
            ListNode top = minHeap.poll();
            tail.next = top;
            tail = tail.next;

            if(top.next!=null)
            {
                minHeap.add(top.next);
            }
        }
        return dummy.next;
    }
}
