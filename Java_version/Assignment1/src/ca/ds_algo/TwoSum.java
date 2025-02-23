package ca.ds_algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/***
 * https://leetcode.com/problems/two-sum/description/
 *
 * Time: O(NlogN)
 * Memory: O(N)
 *
 * I already solved before with the one-pass HashMap-complement method (O(N), O(N)).
 * So I'm trying the two-pointer solution this time. Works but less time-efficient due to sorting.
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Register the values and their corresponding indices
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            ArrayList<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        Arrays.sort(nums);

        // Use a left and a right pointer to look for the pair
        // that contributes to the target
        int left = 0, right = nums.length - 1;
        int sum = 0;

        while (left < right){
            sum = nums[left] + nums[right];
            if(sum == target){
                ArrayList<Integer> list_idx1 = map.get(nums[left]);
                int idx1 = list_idx1.get(0);
                list_idx1.remove(0); // in case duplicate values exist in the original array
                ArrayList<Integer> list_idx2 = map.get(nums[right]);
                int idx2 = list_idx2.get(0);

                return new int[]{idx1, idx2};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }

        return new int[]{};
    }
}
