class Solution {
    // change return type to long
    public long minOperations(int[][] nums) {
        long result = 0L;
        for (int[] range : nums) {
            long L = range[0];
            long R = range[1];
            long countTotal = prefix(R) - prefix(L - 1);
            result += (countTotal + 1) / 2;
        }
        return result;
    }

    private long prefix(long n) {
        if (n <= 0) return 0L;
        long sum = 0L;
        long base = 1L;
        long level = 1L;

        while (base <= n / 4) {
            long cnt = base * 3L;
            sum += cnt * level;
            base *= 4L;
            level++;
        }

        long remaining = n - base + 1;
        sum += remaining * level;
        return sum;
    }
}
