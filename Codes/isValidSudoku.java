class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<String> result = new ArrayList<>();
        int tab = 0;
        int tab1 = 0;
        for(int i=0;i<board.length; i++)
        {
            if(i<=2)
            {
                tab = 1;
            }
            else if(i <= 5)
            {
                tab = 2;
            }
            else
            {
                tab = 3;
            }

            for(int j=0; j<board.length; j++)
            {
                if(j<=2 )
                {
                    tab1 = 1;
                }
                else if(j <= 5)
                {
                    tab1 = 2;
                }
                else
                {
                    tab1 = 3;
                }
                
                if(board[i][j] != '.')
                {
                    
                    if(!(result.contains(board[i][j] + "row in" + i)) && !(result.contains(board[i][j] + "col in"+ j)) && !(result.contains(board[i][j] + "tab in" + tab+" "+tab1)))
                    {
                        result.add(board[i][j] + "row in" + i);
                        result.add(board[i][j] + "col in" + j);
                        result.add(board[i][j] + "tab in" + tab+" "+tab1);
                    }
                    else
                    {
                        return false;
                    }
                } 
                
            }
        }

        return true;
    }
}
