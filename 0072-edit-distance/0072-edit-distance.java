// class Solution {
//     public int minDistance(String word1, String word2) {
//         int[][] dp = new int[word1.length() +1][word2.length() +1]; 
//         for(int i=0; i<=word1.length();i++) {
//             dp[i][0] = i;
//         }
//         for(int i=0; i<=word2.length();i++) {
//             dp[0][i] = i; 
//         }
//         for(int i=1; i<=word1.length();i++) {
//             for(int j=1; j<=word2.length();j++){ 
//                 if(word1.charAt(i-1) == word2.charAt(j-1)) {
//                     dp[i][j] = dp[i-1][j-1];
//                 }else {
//                     dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
//                 }
//             }
//         }
//         // System.out.println(Arrays.deepToString(dp));
//         return dp[word1.length()][word2.length()]; 
//     }
// }

class Solution {
    public int minDistance(String word1, String word2) {
        // int[][] dp = new int[word1.length() +1][word2.length() +1]; 
        int[] prev = new int[word2.length()+1];
        int[] curr = new int[word2.length()+1]; 
        for(int i = 1; i<= word2.length(); i++) {
            prev[i] = i; 
        }
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        // for(int i=0; i<=word1.length();i++) {
        //     dp[i][0] = i;
        // }
        // for(int i=0; i<=word2.length();i++) {
        //     dp[0][i] = i; 
        // }
        for(int i=1; i<=word1.length();i++) {
            curr[0] = i;
            for(int j=1; j<=word2.length();j++){ 
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    curr[j]= prev[j-1];
                }else {
                    curr[j] = 1 + Math.min(curr[j-1], Math.min(prev[j],prev[j-1]));
                }
            }
            // System.out.println("prev"+ " " + Arrays.toString(prev));
            // System.out.println("curr" + " " +Arrays.toString(curr));
            System.arraycopy(curr, 0, prev, 0, curr.length);
        }
        return curr[word2.length()]; 
    }
}