public class Solution {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        int[][] dp = new int[n][n];

        // length is the number of vertices in the interval
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int best = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + A[i] * A[k] * A[j];
                    if (cost < best) best = cost;
                }
                dp[i][j] = (best == Integer.MAX_VALUE) ? 0 : best;
            }
        }
        return dp[0][n - 1];
    }
}
