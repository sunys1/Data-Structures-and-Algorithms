/**
 * 2095. Delete the Middle Node of a Linked List
 *
 * Optimal Solution: the iterative approach using 3 pointers can be
 * inspired by the problem 'Find the Middle Node of a Linked List'.
 *
 * Time: O(N)
 * Space: O(1)
 */

public ListNode deleteMiddle(ListNode head) {
    // Using slow-fast pointer approach:
    // 1. even length: slow will be the middle node
    // 2. odd length: slow.next will be the middle node

    if (head.next == null) return null;

    ListNode prev = head, slow = head, fast = head;
    while(fast != null){
        if(fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }else{
            // Middle node found for odd length list
            break;
        }
    }

    // Remove the middle node
    prev.next = slow.next;
    return head;
}

