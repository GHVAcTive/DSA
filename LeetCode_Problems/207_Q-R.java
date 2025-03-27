import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Create indegree array
        int[] indegree = new int[numCourses];

        // Build the graph and calculate indegree
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Add courses with indegree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Count of courses that can be completed
        int completedCourses = 0;

        // Process the queue
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;

            // Reduce indegree of neighboring courses
            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                // If indegree becomes 0, add to queue
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Return true if all courses are completed, else false
        return completedCourses == numCourses;
    }
}
