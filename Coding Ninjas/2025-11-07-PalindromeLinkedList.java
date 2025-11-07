public class Solution {

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) return true;

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        LinkedListNode<Integer> secondHalf = slow.next;

        LinkedListNode<Integer> firstHalf = head;
        while (secondHalf != null) {
            if (!firstHalf.data.equals(secondHalf.data)) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;
        while (curr != null) {
            LinkedListNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
