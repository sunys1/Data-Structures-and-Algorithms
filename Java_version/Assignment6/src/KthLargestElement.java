import java.util.PriorityQueue;
/**
 * 215. https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * The question asks for the kth largest element in nums without sorting.
 * The property of a min-heap can help us in this case.
 *
 * Using Java's built-in PriorityQueue, which is a min-heap, pushing nums elements
 * into the queue and popping out if the size of the queue is greater than k.
 * At the end, the kth largest element is the top element of the queue.
 *
 * Time: O(Nlogk) - k <= N
 * Space: O(k)
 */
class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // Use a min-heap
        PriorityQueue<Integer> q = new PriorityQueue<>();

        // Push nums elements into the queue.
        // Pop if queue size > k
        for (int e : nums) {
            q.offer(e);
            if (q.size() > k) {
                q.poll();
            }
        }
        // Now the heap contains the top K largest elements.
        // The smallest element is the kth largest, which is the heap top element.
        return q.peek();
    }
}
