class NumArray {
    List<Integer> prefix = new ArrayList<>(); 
    public NumArray(int[] nums) {
        int currSum = 0;
        if(nums == null || nums.length == 0) {
            return;
        }
        for(int i =0; i<nums.length; i++) {
            currSum += nums[i]; 
            prefix.add(currSum);
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return prefix.get(right);
        return prefix.get(right) - prefix.get(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */