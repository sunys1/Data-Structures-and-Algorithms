package ca.dsa;

/***
 * 83. https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Given the list is sorted in ascending order, we can use the same idea as in removing
 * duplicates from sorted array: use 2 pointer slow, fast: fast moves 1 step ahead of slow
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;

        while(fast != null){
            if(slow.val == fast.val){
                fast = fast.next;
                slow.next = fast;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
        }

        return head;
    }
}
