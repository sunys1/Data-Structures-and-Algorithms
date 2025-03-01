package ca.dsa.easy;

/***
 * 234. https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * Time: O(N)
 * Space: O(1)
 *
 * The first idea is to reverse the linked list and compare the reversed list with the original list.
 * This solution is not efficient because it requires extra space.
 * The second idea is to the idea from Q876: use slow-fast pointer approach to find the middle of the list.
 * Then, we can reverse the second half of the list and compare it with the first half.
 *
 */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // use slow and fast pointer to find the middle
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // If list length is odd, slow moves 1 step forward
        if(fast != null){slow = slow.next;}

        // Start comparing
        ListNode reversed = reverse(slow);
        while(reversed != null){
            if(reversed.val != head.val){return false;}
            reversed = reversed.next;
            head = head.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null, cur = head;
        while(cur != null){
            // track next
            ListNode next = cur.next;
            // Cut the tie
            cur.next = prev;
            // advance prev
            prev = cur;
            // advance cur
            cur = next;
        }
        return prev;
    }
}
