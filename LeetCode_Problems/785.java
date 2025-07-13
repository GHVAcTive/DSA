class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means unvisited

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 0; // start with color 0

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node]; // alternate color
                            queue.offer(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false; // same color adjacent: not bipartite
                        }
                    }
                }
            }
        }

        return true;
    }
}
