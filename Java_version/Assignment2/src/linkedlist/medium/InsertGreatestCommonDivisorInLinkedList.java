/***
 * 2807. https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/
 *
 * This is again a slow-fast pointer problem. The node insertion part is easy to think of.
 * But the main part is to get the GCD of the two nodes.
 * The key is to use Euclid's Algorithm to get the GCD.
 * Some languages like C++ has built-in GCD function. For Java I had to look it up
 * and implement as a helper function.
 *
 * Time: O(N)
 * Space: O(1)
 */

public ListNode insertGreatestCommonDivisors(ListNode head) {
    if(head.next == null) return head;
    ListNode slow = head, fast = head.next;

    // Use Euclid's Algorithm to get GCD
    while(fast != null){
        ListNode gcdNode = new ListNode(gcd(slow.val, fast.val), fast);
        slow.next = gcdNode;
        slow = fast;
        fast = fast.next;
    }

    return head;
}

public int gcd(int a, int b){
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}