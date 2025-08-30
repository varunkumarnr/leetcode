class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9]; 
        Set<Character>[] boxs = new HashSet[9]; 

        for(int i =0; i<board.length; i++) {
            rows[i] = new HashSet<>(); 
            cols[i] = new HashSet<>();
            boxs[i] = new HashSet<>(); 
        }

        for(int i=0; i<board.length; i++) {
            for(int j = 0; j<board.length ; j++) {
                if(board[i][j] == '.') continue; 
                int pos  = ((i/3) * 3) +(j/3); 
                if(rows[i].contains(board[i][j]) || cols[j].contains(board[i][j]) || boxs[pos].contains(board[i][j])) {
                    return false; 
                } 
                rows[i].add(board[i][j]);
                cols[j].add(board[i][j]);
                boxs[pos].add(board[i][j]);
            }
        }
        return true; 
    }
}