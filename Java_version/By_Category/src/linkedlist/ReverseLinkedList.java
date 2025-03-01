/***
 * 206. https://leetcode.com/problems/reverse-linked-list/description/
 *
 * Recursive: always assume that the recursion is already done at first
 *
 * Iterative: use a dummy node to keep track of the new head
 */

/***
 * non-Tail-Recursive
 * Divide and conquer approach
 *
 * Time Complexity:
 * 	•	The function traverses each node exactly once.
 * 	•	Each recursive call processes one node (head moves forward).
 * 	•	Since there are n nodes, the recursion depth is O(n).
 * 	•	Each function call does O(1) work (relinking head.next.next = head and setting head.next = null).
 * 	•	Thus, the total time complexity is O(n).
 *
 * 	Space Complexity:
 * 	•	This recursion is not tail-recursive, meaning it builds up a call stack of depth n (for n nodes).
 * 	•	Each recursive call holds an activation record on the call stack, leading to an O(n) space complexity due to recursion.
 * 	•	Unlike the iterative approach (which uses O(1) extra space), this version has an implicit space cost.
 */
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

/***
 * Tail-Recursive
 *
 * The recursive call to reverseListHelper(next, curr) is the last operation in the function.
 * There are no pending operations after the recursion returns, meaning no extra stack frames are needed.
 * This allows for Tail Call Optimization (TCO), which eliminates the additional space overhead from recursion.
 *
 * However, Java does not support Tail Call Optimization (TCO) by default, meaning the call stack still grows to O(n).
 * But conceptually, this approach is a cleaner tail-recursive solution, which is O(1).
 *
 * public ListNode reverseList(ListNode head) {
 *     return reverseListHelper(head, null);
 * }
 */
private ListNode reverseListHelper(ListNode curr, ListNode prev) {
    if (curr == null) {
        return prev; // prev becomes the new head
    }

    ListNode next = curr.next; // Store next node
    curr.next = prev; // Reverse link

    return reverseListHelper(next, curr); // Tail call
}

/***
 * Cleaner and more standard iterative solution
 * Idea is: track next -> cut current.next -> set prev to current -> advance pointers
 * Time: O(N)
 * Space: O(1)
 */
public ListNode reverseList(ListNode head) {
    // iterative solution
    ListNode cur = head, prev = null, next = null;
    while(cur != null){
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    return prev;
}
