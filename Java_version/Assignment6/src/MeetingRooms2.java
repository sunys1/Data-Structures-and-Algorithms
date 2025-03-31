import java.util.*;

/**
 * 253. https://leetcode.com/problems/meeting-rooms-ii/description/
 *
 * This is a classic resource-allocation type of question that I've seen a couple of times in OAs from companies like IBM.
 * A common approach is to use Chronological Ordering - Time: O(NlogN), Space: O(N) - Worst case: all intervals need a new room.
 *
 * Another solution is to use a min-heap:
 * 1. Sort intervals by start time. The ones with early start time also tells us when the rooms will be free for the later ones.
 * 2. Push the end time of the intervals into a min-heap such that the earliest room free time stays on the heap top.
 * 3. Push the first meeting's end time into the heap. Then for each interval, compare the start time with the heap top element, which
 *    tells us whether we can reuse the room or need a new room, either case we need to insert the new interval end time into the heap.
 * 4. At the end, the number of elements remained in the heap tells us the number of rooms needed.
 *
 * Time: O(NlogN + Nlogk) - k: number of meeting rooms needed, k <= N
 * Space: O(k), k <= N
 *
 */

// Solution 1: Min-Heap
class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        // Base case
        if (intervals.length <= 1) return intervals.length;

        // 1. Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 2. Build a min-heap of end times
        PriorityQueue<Integer> roomq = new PriorityQueue<>((a, b) -> {
            return a - b;
        });

        // The heap top element is the earlist room free time
        roomq.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= roomq.peek()) {
                // If the current meeting starts after the meeting room is free, we can reuse the same room.
                // Otherwise, simply assign a new room and add to the heap
                roomq.poll();
            }
            // Assign new room or reuse the room: push the new end time into the heap
            roomq.offer(intervals[i][1]);
        }

        return roomq.size();
    }
}

// Solution 2: Chronological Ordering - Time: O(NlogN), Space: O(N)
public int minMeetingRooms(int[][] intervals) {
    List<int[]> events = new ArrayList<>();

    // Insert (startTime, 1) and (endTime, -1) pairs into the list of events
    for (int[] interval : intervals) {
        events.add(new int[]{interval[0], 1});
        events.add(new int[]{interval[1], -1});
    }

    // Sort the events list by time. If equal, the one representing an end time ranks first.
    Collections.sort(events, (a, b) -> {
        if (a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });

    // Count the number of rooms. Register the max number needed in the process.
    int currNumRooms = 0, maxNumRooms = 0;
    for (int[] event : events) {
        currNumRooms += event[1];
        if (currNumRooms > maxNumRooms) maxNumRooms = currNumRooms;
    }

    return maxNumRooms;
}
