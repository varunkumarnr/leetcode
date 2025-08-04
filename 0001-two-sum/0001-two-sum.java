class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i =0; i< nums.length;i++) {
            int need = target - nums[i];
            if(map.containsKey(need)) {
                int idx= map.get(need); 
                if(idx != i) { 
                    return new int[]{i, idx}; 
                }
            }  
        }
        return new int[]{}; 
    }
}