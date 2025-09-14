class Solution {
    boolean result = false; 
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for( int i = 0; i< nums.length; i++) {
            sum += nums[i];
        }
        if(sum %2 != 0) return false; 
        Boolean[][] memo = new Boolean[nums.length][sum/2];   
        dfs(nums, sum/2, 0, 0, memo); 
        return result; 
    }

    boolean dfs(int[] nums, int required, int curr, int index, Boolean[][] memo)  { 
        if(curr == required) { 
            result = true; 
            return true;  
        }
        if(index >= nums.length) { 
            return false; 
        }
        if(curr > required) return false; 
        if(memo[index][curr] != null) return memo[index][curr];
        memo[index][curr] = false; 
        if(result) {
            return true;
        }
        return dfs(nums, required, curr, index+1, memo) || dfs(nums, required , curr+nums[index], index+1, memo);   
    }
}