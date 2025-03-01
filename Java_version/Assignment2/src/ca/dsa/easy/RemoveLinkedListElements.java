package ca.dsa;

/***
 * 203. https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * Iterative approach:
 *
 * Time: O(N)
 * Space: O(1)
 *
 * The first idea is to a use slow-fast pointer approach
 * Fast advance 1 step ahead of slow: if fast.val == val, fast = fast.next, slow.next = fast;
 *
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){return null;}
        ListNode slow = head, fast = head.next;

        while(fast != null){
            if (fast.val == val){
                fast = fast.next;
                slow.next = fast;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
        }

        return head.val == val ? head.next : head; // in case head.val == val
    }
}

/***
 * Recursive approach:
 *
 * Time: O(N)
 * Space: O(N)
 *
 */
public ListNode removeElements(ListNode head, int val) {
    if(head == null){return null;}

    ListNode next = removeElements(head.next, val);
    if(head.val == val){return next;}
    head.next = next;
    return head;
}