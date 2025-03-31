import java.util.*;
/**
 * 2512. https://leetcode.com/problems/reward-top-k-students/description/
 *
 * Similar to Q692.
 * Takeaway:
 *  1. Turn positve/negative_feedback arrays into sets here makes lookups faster at O(1).
 *  2. Pay attention to the priority order of the comparator out depending on the requirement.
 *
 * Time: O(SetsLength + N * ReportAvgLength + Nlogk + klogk) - k <= N
 * Space: O(SetsLength + N + k)
 */
class RewardTopKStudents {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        // 1. Turn positive and negative feedback arrays into sets
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));

        // 2. Build a points map to store the points of each student
        HashMap<Integer, Integer> points = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            int sid = student_id[i];
            points.put(sid, points.getOrDefault(sid, 0) + getPoints(words, positive, negative));
        }

        // 3. Use a PriorityQueue with custom comparator to store the points entries
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e2.getKey().compareTo(e1.getKey());
            }
            return e1.getValue().compareTo(e2.getValue());
        });

        for (Map.Entry<Integer, Integer> entry : points.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        // 4. Pop the elements and add to the front of the result list
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }

        return res;
    }

    // Calculate points based on report
    public int getPoints(String[] words, Set<String> positive, Set<String> negative) {
        int points = 0;
        for (String word : words) {
            if (positive.contains(word)) points += 3;
            if (negative.contains(word)) points += -1;
        }

        return points;
    }
}

// Solution 2 using Java Record
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));

        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> {
            if (a.points != b.points) return Integer.compare(a.points, b.points); // Min-heap by points
            return Integer.compare(b.id, a.id); // If tie, higher ID gets removed first
        });

        for (int i = 0; i < report.length; i++) {
            int points = toPoints(report[i], positive, negative);
            pq.offer(new Student(student_id[i], points));
            if (pq.size() > k) pq.poll(); // Maintain top k elements
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().id);
        }

        return res;
    }

    private int toPoints(String report, Set<String> positive, Set<String> negative) {
        int points = 0;
        for (String word : report.split(" ")) {
            if (positive.contains(word)) points += 3;
            else if (negative.contains(word)) points -= 1;
        }
        return points;
    }

    record Student(int id, int points) {}
}