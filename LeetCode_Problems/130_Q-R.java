class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        if (rows == 0 || cols == 0) return;
        
        // Mark connected 'O's from the borders
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }
        
        // Flip remaining 'O's to 'X' and restore marked 'O's to original
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        int rows = board.length, cols = board[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != 'O') return;
        
        board[i][j] = '#'; // Mark visited O to avoid flipping
        
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
