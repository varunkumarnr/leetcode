class Solution {
    HashMap<String, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int ans = dfs(coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int dfs(int[] coins, int amount, int index) {
        if (amount == 0) return 0;
        if (index >= coins.length || amount < 0) return Integer.MAX_VALUE;

        String key = index + "|" + amount;
        if (memo.containsKey(key)) return memo.get(key);

        int skip = dfs(coins, amount, index + 1);

        int take = dfs(coins, amount - coins[index], index);
        if (take != Integer.MAX_VALUE) take += 1;

        int result = Math.min(skip, take);
        memo.put(key, result);
        return result;
    }
}
