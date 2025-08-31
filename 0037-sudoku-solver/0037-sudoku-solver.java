class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board); 
    }
    boolean backtracking(char[][] board) {
        for(int i =0; i< board.length; i++) {
            for(int j =0; j< board.length; j++) {
                if(board[i][j] != '.') continue;
                for(char k = '1'; k <= '9'; k++) {
                    if(isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if(backtracking(board)) {
                            return true; 
                        }
                        board[i][j] = '.';
                    }               
                }
                return false;
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int row,int  col, char c) {
        for(int i = 0; i< board.length; i++) {
            if(board[i][col] == c) return false;
            if(board[row][i] ==c) return false; 
            int boxRow = (row/3)*3 + i/3; // 2 , 1
            int boxCol = (col/3)*3 + i%3; 
            if(board[boxRow][boxCol] == c) return false; 
        }
        return true;  
    }
}