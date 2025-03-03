package ca.dsa.easy;

/***
 * 3217. https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/
 *
 * First idea was to convert the array into a list
 * Then use slow-fast pointer to check if the node value is present in the list
 * This approach trigger time limit exceeded. Adding to the end is O(1), but
 * the average checking time is O(n).
 *
 * Since the array contains unique values, we can use a HashSet to store the values.
 * The average adding/checking time complexity is O(1).
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Add all elements of nums into a Set
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        ListNode slow = head, fast = head.next; // Given that nums.length >= 1

        while(fast != null){
            if(set.contains(fast.val)){
                fast = fast.next;
                slow.next = fast;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
        }

        return set.contains(head.val) ? head.next : head;
    }
}

/***
 * Optimal solution with Boolean Array Lookup
 * Boolean array lookup is constant O(1), faster than HashSet on-average O(1) lookup
 * Also, this approach avoided looking up values that are not in the array
 *
 * Time: O(n)
 * Space: O(N)
 */

public ListNode modifiedList(int[] nums, ListNode head) {
    // Find max in nums and build a boolean array
    int max=0;
    for(int num:nums){
        if(max<num) {max=num;}
    }
    boolean[] check= new boolean[max+1];
    for(int num: nums) {check[num]=true;}

    ListNode slow = head, fast = head.next; // Given that nums.length >= 1

    while(fast != null){
        if(fast.val <= max && check[fast.val]){
            fast = fast.next;
            slow.next = fast;
        }else{
            slow = slow.next;
            fast = fast.next;
        }
    }

    return head.val <= max && check[head.val] ? head.next : head;
}