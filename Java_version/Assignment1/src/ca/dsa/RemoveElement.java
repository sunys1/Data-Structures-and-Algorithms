package ca.dsa;

/***
 * https://leetcode.com/problems/remove-element/description/
 *
 * Time: O(N)
 * Space: O(1)
 *
 * Same approach as applied in Q26 with slight variation.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        //Use a slow pointer and a fast pointer
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                // Here we update value then increment because slow could be out of bound.
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
