package ca.dsa.easy;

/***
 * 141. Linked List Cycle
 *
 * Use a slow and fast pointer to find the cycle.
 * Since fast moves twice the speed of slow, if there is a cycle, they will meet.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){return false;};

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){return true;}
        }

        return false;
    }
}
