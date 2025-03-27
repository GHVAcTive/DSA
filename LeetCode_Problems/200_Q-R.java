public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Loop through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If a land cell is found, trigger DFS and increase island count
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    // DFS to mark all connected land cells as visited
    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary and water check
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited
        grid[i][j] = '0';

        // Visit all 4 neighbors (up, down, left, right)
        dfs(grid, i - 1, j); // Up
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j - 1); // Left
        dfs(grid, i, j + 1); // Right
    }
}
