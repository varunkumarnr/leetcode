// class Solution {
//     // have a list of all connects and only update when valid.............
//     public void solve(char[][] board) {
//         int num = 0; 
//         for(int i=0; i<board.length; i++) {
//             for(int j=0; j<board[0].length; j++) {
//                 List<List<Integer>> region  = new ArrayList<>(); 
//                 boolean[] isCornerConnected = new boolean[1]; 
//                 if(board[i][j] == 'O') {
//                     dfs(i,j,board, region, isCornerConnected);
//                 }
//                 // conver # to 0
//                 if(!isCornerConnected[0]) {
//                     for(int k = 0; k<region.size(); k++) {
//                         List<Integer> curr = region.get(k);
//                         board[curr.get(0)][curr.get(1)] = 'X';
//                     }
//                 }
//             }
//         }
//         for(int i=0; i<board.length; i++) {
//             for(int j=0; j<board[0].length; j++) {
//                 if(board[i][j] == '#') {
//                     board[i][j] = 'O'; 
//                 }
//             }
//         }
//     }
//     void dfs(int i,int j, char[][] board,List<List<Integer>> region, boolean[] isCornerConnected) {
//         // if current connection as a corner
//         if(i<=0||j<=0||i>=board.length-1|| j>=board[0].length-1) {
//             if (board[i][j] == 'O') {
//             isCornerConnected[0] = true;
//             return;}
//         }
//         if(board[i][j] != 'O') {
//             return;
//         }
//         // visited temp check
//         board[i][j] = '#'; 
//         region.add(new ArrayList<>(Arrays.asList(i,j))); 

//         // left 
//         dfs(i, j+1, board, region, isCornerConnected);
//         // right
//         dfs(i,j-1, board, region, isCornerConnected);
//         //top
//         dfs(i-1, j, board, region, isCornerConnected);
//         //bottom
//         dfs(i+1, j, board, region, isCornerConnected);
//     }
// }

class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i<board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length-1);
        }
        for(int j=0; j<board[0].length; j++) {
            dfs(board, 0, j); 
            dfs(board, board.length - 1,  j);
        }

        for(int i =0; i< board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    void dfs(char[][] board, int i, int j) {
        if(i<0 || j<0|| j>board[0].length-1 || i>board.length-1||board[i][j] !='O') {
            return; 
        }
        board[i][j] = '#'; 

        // right
        dfs(board, i, j+1);
        // left
        dfs(board, i,j-1);
        //top
        dfs(board, i-1, j);
        //bottom
        dfs(board, i+1, j);
    }
}