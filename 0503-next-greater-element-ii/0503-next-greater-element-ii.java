class Solution {
    public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Stack<Integer> stack = new Stack<>(); // stores indexes

    for (int i = 2 * n - 1; i >= 0; i--) {
        int num = nums[i % n];
        while (!stack.isEmpty() && nums[stack.peek()] <= num) {
            stack.pop();
        }
        if (i < n) {
            if (!stack.isEmpty()) {
                result[i] = nums[stack.peek()];
            }
        }
        stack.push(i % n);
    }

    return result;
}

}