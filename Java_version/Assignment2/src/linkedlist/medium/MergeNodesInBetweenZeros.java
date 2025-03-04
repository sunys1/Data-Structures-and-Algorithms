/***
 * 2181. https://leetcode.com/problems/merge-nodes-in-between-zeros/
 *
 * Iterative Solution:
 * slow-fast pointer approach. Create new sum nodes and remove zero nodes in one pass.
 *
 * Time: O(N)
 * Space: O(1)
 *
 */
public ListNode mergeNodes(ListNode head) {
    ListNode slow = head, fast = head.next;
    int sum = 0;

    while (fast != null) {
        if (fast.val != 0) {
            sum += fast.val;
        } else {
            slow.next = new ListNode(sum);
            slow = slow.next;
            sum = 0;
        }
        fast = fast.next;
    }

    return head.next; // Skip the initial zero node
}
