public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // If the current cell is empty (represented by '.')
                if (board[row][col] == '.') {
                    // Try every number from '1' to '9'
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Try this number
                            
                            // Recursively try to solve the rest of the board
                            if (solve(board)) {
                                return true;
                            }
                            
                            // If it didn't work, backtrack by resetting the cell
                            board[row][col] = '.';
                        }
                    }
                    return false; // No valid number found, return false to backtrack
                }
            }
        }
        return true; // The board is completely filled and valid
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check if the number is not in the current row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check if the number is not in the current column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check if the number is not in the current 3x3 subgrid
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // The number is valid
    }
}
