/***
 * 237. https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 *
 * Simply overwrite the node value instead of moving the actual node objects
 */
public class DeleteNodeInALinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
