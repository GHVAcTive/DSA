import java.util.*;

class Solution {

    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        int[][] mem = new int[m][n];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        Queue<AbstractMap.SimpleEntry<Integer, Integer>> q = new ArrayDeque<>();
        dfs(grid, 0, 0, 0, q, mem);

        for (int cost = 1; !q.isEmpty(); ++cost) {
            for (int sz = q.size(); sz > 0; --sz) {
                AbstractMap.SimpleEntry<Integer, Integer> pair = q.poll();
                final int i = pair.getKey();
                final int j = pair.getValue();
                for (int[] dir : dirs) {
                    dfs(grid, i + dir[0], j + dir[1], cost, q, mem);
                }
            }
        }

        return mem[m - 1][n - 1];
    }

    private void dfs(int[][] grid, int i, int j, int cost, Queue<AbstractMap.SimpleEntry<Integer, Integer>> q, int[][] mem) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
            return;
        }
        if (mem[i][j] != -1) {
            return;
        }
        mem[i][j] = cost;
        q.add(new AbstractMap.SimpleEntry<>(i, j));
        int[] dir = dirs[grid[i][j] - 1];
        dfs(grid, i + dir[0], j + dir[1], cost, q, mem);
    }
}
