package ca.dsa;

/***
 * 160. https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * A bit tricky to think of at first. The idea is to use two pointers to traverse the two linked lists.
 * By reaching the end, connect the tail to the head of the other list.
 * Eventually, the 2 pointers will meet at the intersection point because they
 * move at the same speed for the same distance.
 */

public class IntersectionTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // connect p1 to headB and keep moving
            if (p1 == null) p1 = headB;
            else{
                p1 = p1.next;
            }
            // connect p2 to headA and keep moving
            if (p2 == null) p2 = headA;
            else{
                p2 = p2.next;
            }
        }
        return p1;
    }
}
