class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() > board[0].length * board.length) return false;
        for(int i=0; i<board.length; i++) {
            for(int j =0; j< board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
    return true;
}
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int idx, int i,int j) {
        if(idx == word.length())return true;
        if(i<0 || j<0 || i>=board.length || j>= board[0].length|| word.charAt(idx) != board[i][j]) return false; 
        char temp =  board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, word, idx+1, i, j-1) || 
        dfs(board, word, idx+1, i, j+1) ||
        dfs(board, word, idx+1, i-1, j) ||
        dfs(board, word, idx+1, i+1, j); 
        board[i][j] = temp; 
        return found; 
    }
}