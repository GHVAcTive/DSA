import java.util.*;

class Solution {
    public int scheduleCourse(int[][] courses) {
        // Sort courses by their end time (lastDay)
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalTime = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            // Add the course
            totalTime += duration;
            maxHeap.offer(duration);

            // If total time exceeds lastDay, remove the longest course
            if (totalTime > lastDay) {
                totalTime -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}
