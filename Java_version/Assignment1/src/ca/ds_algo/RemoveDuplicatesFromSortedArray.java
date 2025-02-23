package ca.ds_algo;

/***
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * Time: O(N) one-pass
 * Space: O(1)
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // Use a slow and a fast pointer.
        int slow = 0, fast = 0;
        for(fast = 0; fast < nums.length; fast++){
            //Let index fast increment first and check if the indexed element is different than the element at index slow
            //If a different element is found at fast, increment slow and update it to the new value to form a non-repetitive array
            if(nums[fast] != nums[slow]){
                // Here we increment then update without the concern of OutOfBound exception
                // because slow is always behind fast
                slow++;
                nums[slow] = nums[fast];
            }
        }

        //The first k element = nums[0...slow]
        return slow+1;
    }
}
