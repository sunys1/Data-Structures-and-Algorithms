/***
 * 206. https://leetcode.com/problems/reverse-linked-list/description/
 *
 * Recursive: always assume that the recursion is already done at first
 *
 * Iterative: use a dummy node to keep track of the new head
 */

// Recursive
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //base case
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head; //add reversed link between 2 nodes
        head.next = null; //delete the original link

        return newHead;
    }
}

// Iterative
public ListNode reverseList(ListNode head) {
    // iterative solution
    if (head == null || head.next == null) {return head;}

    ListNode newHead = new ListNode(), dummy = new ListNode();
    dummy.next = head;
    newHead = head.next;

    while(newHead != null){
        head.next = newHead.next;
        newHead.next = dummy.next;
        dummy.next = newHead;
        newHead = head.next;
    }
    return dummy.next;
}
