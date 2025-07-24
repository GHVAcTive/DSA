class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], x = curr[1], y = curr[2];

            if (visited[x][y]) continue;
            visited[x][y] = true;

            if (x == n - 1 && y == n - 1) return time;

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{Math.max(time, grid[nx][ny]), nx, ny});
                }
            }
        }

        return -1;
    }
}
