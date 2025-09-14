class Solution {

    boolean result = false; 
    Map<String, Boolean> memo = new HashMap<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =0; 
        for(int i =0; i<nums.length; i++) { 
            sum+=nums[i]; 
        }
        if(sum % k != 0) { 
            return false;
        } 
        dfs(nums, sum/k, k , 0, 0, new ArrayList<>(), new int[nums.length], 0); 
        return result; 
    }

    void dfs(int[] nums, int target, int k, int counter, int currSum, List<Integer>  curr, int[] visited, int i) { 
        if (counter == k) {  
                result = true;
                return;
            }
        if (currSum == target) {
            for (int idx : curr) visited[idx] = 1; 
            curr.clear();
            dfs(nums, target, k, counter + 1, 0, curr, visited, 0);
            return; 
        }
        if (currSum > target || i >= nums.length || result) return; 
        String key = Arrays.toString(visited) + "|" + currSum;
        if (memo.containsKey(key)) return;
        memo.put(key, true);

         for (int j = i; j < nums.length; j++) {
            if (visited[j] == 1) continue;
            curr.add(j);
            visited[j] = 1; 
            dfs(nums, target, k, counter, currSum + nums[j], curr, visited, j + 1);
            visited[j] = 0; 
            if (!curr.isEmpty()) {          
                curr.remove(curr.size() - 1);
            } 
        }
    }
}