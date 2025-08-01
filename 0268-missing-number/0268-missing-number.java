class Solution {
    public int missingNumber(int[] nums) {
        int allSum = 0; 
        int givenSum =0;
        for(int i = 0; i<=nums.length;i++) {
            allSum += i; 
        }
        for(int j=0; j<nums.length;j++) {
            givenSum +=nums[j]; 
        }
        return allSum-givenSum; 
    }
}