package ca.dsa;

/***
 * 876. https://leetcode.com/problems/middle-of-the-linked-list/description/
 *
 * Time: O(N)
 * Space: O(1)
 *
 * Use a slow and fast pointer.
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        // Fast pointer advances 2 times faster than the slow pointer
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // When fast points to null, slow is at the middle node of an odd length list
        // or at the second middle node of an even length list.
        return slow;
    }
}
