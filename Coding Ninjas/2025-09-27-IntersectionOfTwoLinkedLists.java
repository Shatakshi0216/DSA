public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        if (firstHead == null || secondHead == null) return -1;

        Node p1 = firstHead;
        Node p2 = secondHead;

        while (p1 != p2) {
            p1 = (p1 == null) ? secondHead : p1.next;
            p2 = (p2 == null) ? firstHead : p2.next;
        }

        return (p1 == null) ? -1 : p1.data;
    }
}
