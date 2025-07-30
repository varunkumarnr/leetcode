class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    max = Math.max(max, dp[j]);
                }
            }
        }
        return max;
    }
}
