/**
 * 2130. https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
 *
 * Iterative Solution: this approach is easy to think of. The inefficiency is that
 * we have to traverse the list to get the length first, and use extra space
 * to store pair values.
 *
 * Time: O(N)
 * Space: O(N
 */
class Solution {
    public int pairSum(ListNode head) {
        int maxTwinSum = 0, n = getLength(head);
        int[] pairs = new int[n];
        ListNode curr = head;

        for (int i = 0; i < n; i++) {
            int twinIdx = getTwinIndex(i, n);
            if (pairs[twinIdx] != 0) {
                maxTwinSum = curr.val + pairs[twinIdx] > maxTwinSum ? curr.val + pairs[twinIdx] : maxTwinSum;
            } else {
                pairs[i] = curr.val;
            }

            curr = curr.next;
        }

        return maxTwinSum;
    }

    private int getTwinIndex(int currIdx, int n) {
        int twinIdx = n - 1 - currIdx;
        return twinIdx;
    }

    private int getLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length += 1;
            head = head.next;
        }

        return length;
    }
}
