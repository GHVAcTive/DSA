class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        // Check for empty matrix
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m * n];
        
        int row = 0, col = 0, direction = 1; // direction = 1 for upward, -1 for downward
        
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            
            // Moving up
            if (direction == 1) {
                if (col == n - 1) {  // Reached last column, go down
                    row++;
                    direction = -1;
                } else if (row == 0) {  // Reached top row, move right
                    col++;
                    direction = -1;
                } else {  // Move diagonally up
                    row--;
                    col++;
                }
            }
            // Moving down
            else {
                if (row == m - 1) {  // Reached last row, move right
                    col++;
                    direction = 1;
                } else if (col == 0) {  // Reached first column, go down
                    row++;
                    direction = 1;
                } else {  // Move diagonally down
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}

