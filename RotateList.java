/**
 * 
Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
public class RotateList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Be careful with traps, edge cases, go through different test cases
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head; //key

        ListNode pEnd = head;
        int len = 1; //key
        while(pEnd.next != null) {
            pEnd = pEnd.next;
            len++;
        }
        pEnd.next = head;
        int step = len - k % len; //key
        ListNode p = head;
        while (--step > 0) { //key --
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }

}
