class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1]; 
        for(int i = 1; i <= m; i++ ) {
            for(int j =1; j <=n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                } 
            }
        }
        return dp[m][n]; 
    }
}

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//        return lcs(text1, text2, text1.length(), text2.length()); 
//     }
//     public int lcs(String text1, String text2, int m, int n) {
//         if(m == 0 || n == 0) return 0; 
//         if(text1.charAt(m-1) == text2.charAt(n-1)) {
//             return 1 + lcs(text1, text2, m-1,n-1);
//         }
//         return Math.max(lcs(text1, text2, m-1,n), lcs(text1, text2,m, n-1)); 
//     }
// }

// class Solution {
//     Map<Pair, Integer> memo = new HashMap<>();

//     public int longestCommonSubsequence(String text1, String text2) {
//         return lcs(text1, text2, text1.length(), text2.length());
//     }

//     int lcs(String t1, String t2, int m, int n) {
//         if (m == 0 || n == 0) return 0;

//         Pair key = new Pair(m, n);
//         if (memo.containsKey(key)) return memo.get(key);

//         int result;
//         if (t1.charAt(m - 1) == t2.charAt(n - 1)) {
//             result = 1 + lcs(t1, t2, m - 1, n - 1);
//         } else {
//             result = Math.max(lcs(t1, t2, m - 1, n), lcs(t1, t2, m, n - 1));
//         }

//         memo.put(key, result);
//         return result;
//     }

//     record Pair(int m, int n) {}
// }


