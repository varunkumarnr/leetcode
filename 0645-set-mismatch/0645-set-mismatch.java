class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2]; 
        int sum = 0; 
        for(int i =0; i<nums.length; i++) { 
            if(i!= nums.length-1 && nums[i] == nums[i+1]) {
                result[0] = nums[i]; 
                continue;
            } 
            sum+= nums[i]; 
        }  
        System.out.println(sum); 
        int missingNumber = ((nums.length * (nums.length +1)) /2) - sum; 
        result[1] = missingNumber;
        return result; 
    }
}