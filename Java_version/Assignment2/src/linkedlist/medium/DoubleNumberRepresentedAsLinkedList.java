/***
 * 2816. https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/
 *
 * Following the intuitive approach of calculating the carry and the value of each node,
 * we can use a recursive approach to solve this problem.
 *
 * Time: O(N)
 * Space: O(N)
 */

public ListNode doubleIt(ListNode head) {
    if(helper(head) == 1){
        head = new ListNode(1, head);
    }

    return head;
}

public int helper(ListNode head){
    // Recursion base case
    if (head == null){
        return 0;
    }

    int doubledVal = 2 * head.val + helper(head.next);
    int carry = doubledVal >= 10 ? 1 : 0;
    head.val = doubledVal % 10;

    return carry;
}

/***
 * Faster solution
 *
 * Time: O(N)
 * Space: O(1)
 */

public ListNode doubleIt(ListNode head) {
    // If head is greater than 4, insert a new node with value 0 at the beginning
    if (head.val > 4) {
        head = new ListNode(0, head);
    }

    ListNode curr = head;
    while (curr != null) {
        // Double the value and handle carry
        curr.val = (curr.val * 2) % 10;

        // If next doubled value >= 10, increment the current node's value by 1
        if (curr.next != null && curr.next.val > 4) {
            curr.val++;
        }

        curr = curr.next; // Move to the next node
    }

    return head;
}