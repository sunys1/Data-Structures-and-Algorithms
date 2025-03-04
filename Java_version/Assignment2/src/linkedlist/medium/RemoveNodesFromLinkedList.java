/***
 * 2487. https://leetcode.com/problems/remove-nodes-from-linked-list/description/
 *
 * Since we only care about if there is a larger value on the right, an intuitive approach
 * is to use Recursion to check if the current node needs to be removed.
 *
 * Time: O(N)
 * Space: O(N)
 */

class Solution {
    public ListNode removeNodes(ListNode head) {

        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if (head == null) return null;

        head.next = helper(head.next);

        if (head.next != null && head.val < head.next.val) {
            return head.next; // Remove current node
        }

        return head; // Keep current node
    }
}

/***
 * Faster Solution:
 *
 * The iterative solution is to reverse the linked list, modify the list in place,
 * then reverse the list back.
 *
 * Time: O(N)
 * Space: O(1)
 */

public ListNode removeNodes(ListNode head) {
    // Reverse the list
    ListNode curr = head, prev = null, next;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    // Modify the reversed list in-place
    head = prev;
    curr = head;
    int maxVal = curr.val;

    while (curr.next != null) {
        if (curr.next.val < maxVal) {
            curr.next = curr.next.next; // Remove node
        } else {
            maxVal = curr.next.val;
            curr = curr.next;
        }
    }

    // Reverse the list back to original order
    prev = null;
    curr = head;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}