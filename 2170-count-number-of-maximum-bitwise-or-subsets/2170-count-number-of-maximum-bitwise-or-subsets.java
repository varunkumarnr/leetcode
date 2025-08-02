class Solution {
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        backtrack(nums, 0, 0, maxOr);
        return count;
    }

    void backtrack(int[] nums, int index, int currOr, int maxOr) {
        if (index == nums.length) {
            if (currOr == maxOr) count++;
            return;
        }

        backtrack(nums, index + 1, currOr | nums[index], maxOr);
        backtrack(nums, index + 1, currOr, maxOr);
    }
}
