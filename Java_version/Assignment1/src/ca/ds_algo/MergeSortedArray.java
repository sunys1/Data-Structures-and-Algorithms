package ca.ds_algo;

/***
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * Time: O(N)
 * Space: O(1)
 *
 * Similar to Q21 Merge Two Sorted Lists. Instead, we merge from the back.
 * P1 and p2 are like the zipper teeth, and p3 is like the slider of a zipper
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Use 3-pointers approach
        int p1 = m - 1, p2 = n - 1, p3 = nums1.length - 1;

        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p3] = nums1[p1];
                p1--;
            }else{
                nums1[p3] = nums2[p2];
                p2--;
            }
            p3--;
        }

        // Either nums1 or nums2 finished looping.
        // We only need to look at nums2 since we are inserting from nums2 into nums1.
        while(p2 >= 0){
            nums1[p3] = nums2[p2];
            p2--;
            p3--;
        }
    }
}
