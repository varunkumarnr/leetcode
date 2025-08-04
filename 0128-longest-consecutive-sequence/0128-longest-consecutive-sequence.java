class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); 
        for(int i = 0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        int maxSequence = 0; 
        for(int n: set) {
            int curr = 1; 
            if(!set.contains(n-1)) {
                while(set.contains(n+1)) {
                    curr++; 
                    n++;
                } 
            }
            maxSequence = Math.max(maxSequence, curr); 
        }
        return maxSequence; 
     }
}