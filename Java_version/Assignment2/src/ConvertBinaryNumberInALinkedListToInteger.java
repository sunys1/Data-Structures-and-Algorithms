/***
 *  1290. https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 *
 *  Time: O(N)
 *  Space: O(N)
 *
 *  Since head is the most significant bit, the first idea came to my mind is to reverse the list
 *  and then iterate through it.
 */

public class ConvertBinaryNumberInALinkedListToInteger {
    public int degree = 0;
    public int decimal = 0;
    public int getDecimalValue(ListNode head) {
        // we know that the list is not empty. 0*2^0 = 0, 1*2^0 = 1;
        if(head.next == null){return head.val;}
        head = helper(head);
        return decimal;
    }

    public ListNode helper(ListNode head){
        if(head.next == null) {
            decimal += head.val * Math.pow(2, degree);
            degree++;
            return head;
        };

        ListNode newHead = helper(head.next);
        head.next.next = head;
        head.next = null;
        decimal += head.val * Math.pow(2, degree);
        degree++;

        return newHead;
    }
}

/***
 * Bit Manipulation Solution
 * Time: O(N)
 * Space: O(1)
 *
 * Decimal starts at 0. By shifting decimal left by 1 and adding the current bit,
 * we multiply decimal by 2 and insert the current bit for reconstruting the binary number.
 * The most significant figure inserted at the least significant position will eventually be
 * shifted back to the most significant position.
 *
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int decimal = 0;
        while(head != null){
            decimal = decimal << 1 | head.val;
            head = head.next;
        }
        return decimal;
    }
}




