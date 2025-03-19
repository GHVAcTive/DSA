import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        // Store projects as pairs of (capital, profit)
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());

        // Add all projects to minCapital heap
        for (int i = 0; i < n; i++) {
            minCapital.offer(new int[]{capital[i], profits[i]});
        }

        // Process up to k projects
        for (int i = 0; i < k; i++) {
            // Move all affordable projects to maxProfit heap
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                maxProfit.offer(minCapital.poll()[1]);
            }
            
            // If no projects are affordable, stop
            if (maxProfit.isEmpty()) {
                break;
            }
            
            // Choose the most profitable project
            w += maxProfit.poll();
        }

        return w;
    }
}
