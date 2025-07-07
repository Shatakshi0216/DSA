class Solution {
    public ListNode findKthNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null) prevNode.next = temp;
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            // ✅ Reverse and store the new head
            ListNode reversedHead = reverse(temp);

            // ✅ Link previous group with reversed head
            if (temp == head) {
                head = reversedHead;
            } else {
                prevNode.next = reversedHead;
            }

            // ✅ Link last node of reversed group to nextNode
            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }
}
