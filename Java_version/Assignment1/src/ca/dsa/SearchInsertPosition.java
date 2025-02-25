package ca.dsa;

/***
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * Time: O(logN)
 * Sapce: O(1)
 *
 * Problem description requires a solution with O(logN).
 * Binary search is known for best case O(1) and average case/worst case O(logN).
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // Use binary search
        int left = 0, right = nums.length - 1; // [left, ... right] closed search interval

        while(left <= right){
            int middle = (left + right) / 2; // or left + (right - left) / 2 to prevent overflow in case of very large values
            if (nums[middle] == target){
                return middle;
            }else if (nums[middle] < target){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }

        // Now left = right + 1: nums[right] < target <= nums[left]
        return left;
    }
}
