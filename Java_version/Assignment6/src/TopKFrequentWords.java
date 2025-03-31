import java.util.*;

/**
 * 692. https://leetcode.com/problems/top-k-frequent-words/description/
 *
 * Similar to Q347. The only difference is that we need to sort words with equal frequency
 * by their lexicographical order in the custom comparator.
 *
 * Time: O(N + UlogK) U - number of unique words. Worst case: U = N
 * Space: O(k) - k <= U
 */
class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. Build a frequency map to store the count of each word
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // 2. Use a PriorityQueue with custom comparator to store the freqMap entries
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            // If the frequencies are equal, sort by lexicographical order
            if (e1.getValue().equals(e2.getValue())) {
                return e2.getKey().compareTo(e1.getKey());
            }

            return e1.getValue().compareTo(e2.getValue());
        });

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        // 3. Poll the elements and add to the result list from the back to the front.
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }

        return res;
     }
}
