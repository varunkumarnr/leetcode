class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int result = dfs(coins, amount); 
        return result == Integer.MAX_VALUE ? -1 : result ;
    }

    int dfs(int[] coins, int amount) {
        if(amount == 0) {
            return 0; 
        }
        if(amount < 0) {
            return Integer.MAX_VALUE; 
        }
        if (memo.containsKey(amount)) return memo.get(amount);
        int min = Integer.MAX_VALUE;
        for(int i= 0; i<coins.length; i++) {
           int res =  dfs(coins, amount - coins[i]); 
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        } 
        memo.put(amount, min);
        return min; 
    }
}
