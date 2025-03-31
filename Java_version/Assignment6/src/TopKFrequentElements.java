import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * The question asks for a time complexity better than O(NlogN).
 * We can build a frequency map to store the count of each element.
 * Then use a min-heap PriorityQueue with a custom comparator to store the value-frequency pairs.
 * Similar to Q215, we add elements to the queue and poll() if queue size > k to
 * maintain the top K frequency elements in the heap.
 *
 * At the end, the heap contains the top K frequent elements with the least frequent one at the top.
 * Poll the elements and add them to the result array from the back to the front.
 * Time: O(N + Ulogk) : U - number of unique elements in the array. Worst case: U = N
 * Space: O(k) k <= U
 *
 */
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build a hash map to store the frequency of each element.
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int e : nums) {
            freqMap.put(e, freqMap.getOrDefault(e, 0) + 1);
        }

        //2. Use a min-heap with custom comparator to store the elements with their frequencies.
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((e1, e2) -> {
            return e1.getValue().compareTo(e2.getValue());
        });

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 3. Now the min-heap contains the top K frequent elements. The top element has the smallest frequency.
        //    Poll the elements and add to the result array from the back to the front.
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().getKey();
        }

        return res;
    }
}