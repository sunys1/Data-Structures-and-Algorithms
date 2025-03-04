/**
 * 2074. https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
 *
 * This one is a bit tricky and took quite some time to
 * sort out the logic without using hint.
 *
 * Track each group with 2 pointers. Reverse even group only; skip odd groups.
 * Count actual node length and handle last group edge case.
 *
 *  * Time: O(N)
 *  * Space: O(1)
 *
 * Restructured by Grok3 to improve readability. The frame work is the same.
 */

public ListNode reverseEvenLengthGroups(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prevGroupEnd = dummy;
    int groupSize = 1;

    while (prevGroupEnd.next != null) {
        ListNode cur = prevGroupEnd.next;

        // Count actual nodes in this group (might be less than groupSize at the end)
        int actualLength = 0;
        ListNode temp = cur;
        while (temp != null && actualLength < groupSize) {
            actualLength++;
            temp = temp.next;
        }

        // Only reverse if actual length is even
        if (actualLength % 2 == 0) {
            ListNode groupStart = cur;
            ListNode prev = null;
            ListNode nextNode;

            // Reverse the group
            for (int i = 0; i < actualLength; i++) {
                nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
            }

            // Connect with previous group
            ListNode nextGroupStart = groupStart.next;
            prevGroupEnd.next = prev;
            groupStart.next = cur;
            prevGroupEnd = groupStart;
        } else {
            // Move to end of current group without reversing
            ListNode last = cur;
            for (int i = 1; i < actualLength; i++) {
                last = last.next;
            }
            prevGroupEnd = last;
        }

        groupSize++;  // Increase expected group size for next iteration
    }

    return dummy.next;
}