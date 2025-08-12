class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][] memo;
    private List<Integer> powers;

    public int numberOfWays(int n, int x) {
        powers = new ArrayList<>();
        int maxBase = 1;
        while (true) {
            int val = (int) Math.pow(maxBase, x);
            if (val > n) break;
            powers.add(val);
            maxBase++;
        }

        memo = new int[n + 1][powers.size() + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(n, 0);
    }

    private int dfs(int remaining, int index) {
        if (remaining == 0) return 1;
        if (remaining < 0 || index >= powers.size()) return 0;

        if (memo[remaining][index] != -1) return memo[remaining][index];

        int ways = dfs(remaining - powers.get(index), index + 1);
        ways = (ways + dfs(remaining, index + 1)) % MOD;

        memo[remaining][index] = ways;
        return ways;
    }
}
