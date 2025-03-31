/**
 * 912. https://leetcode.com/problems/sort-an-array/description/
 *
 * The question asks us to sort an array without using built-in functions,
 * in O(NlogN) complexity with the smallest possible space complexity.
 *
 * Since we learned that we can use heapify to build a heap directly from
 * an array of integers, we can build a max heap here and sort the array by
 * repetitively extracting the largest element from the heap.
 *
 * Using a max-heap here is more efficient than a min-heap because the final
 * result using a max-heap will be in ascending order. Using a min-heap
 * requires reversing the final result to get the ascending array.
 *
 * Time: O(NlogN)
 * Space: O(1)
 */

class SortAnArray {
    public int[] sortArray(int[] nums) {
        // 1. Build a heap from nums.
        buildHeap(nums, nums.length);

        // 2. Sort by repeatedly extracting the largest element and placing it at the end.
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i); // Maintain the heap property
        }

        return nums;
    }

    // Restores the max-heap property
    public void heapify(int[] nums, int root, int size) {
        int left = (root << 1) + 1;
        int right = (root << 1) + 2;
        int largest = root;

        if (left < size && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != root){
            swap(nums, root, largest);
            heapify(nums, largest, size);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Build a heap from nums using the bottom-up approach. O(N).
    public void buildHeap(int[] nums, int size) {
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            heapify(nums, i, size);
        }
    }
}