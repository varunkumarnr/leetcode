// class Solution {
//     public long minOperations(int[][] nums) {
//         /*
//             1 , 2, 3, 4, 5, 6, 7,  8
//             1  1 1   2   2   2  2  2 13/ 2 = 7 
        
        
//          */
//         List<List<Integer>> input = new ArrayList(); 
//         long result = 0; 
//         for(int i =0; i < nums.length; i++) {
//             List<Integer> curr = new ArrayList<>(); 
//             for(int j = nums[i][0] ; j <= nums[i][1]; j++) {
//                 curr.add(j); 
//             }
//             input.add(curr); 
//         }
//         HashMap<Integer, Integer> map = new HashMap<>(); 
//         for(List<Integer> i: input) {
//             long countTotal = 0; 
//             for(int k: i ) {
//                 int temp = k; 
//                 int count = 0; 
//                 if(map.containsKey(k)){ 
//                     count = map.get(k); 
//                     countTotal += count; 
//                     continue; 
//                 }
//                 while(k>0) {
//                     k = (int) Math.floor((double) k/4); 
//                     count++; 
//                 }
//                 countTotal += count; 
//                 map.put(temp, count); 
//             }
//             result += (countTotal + 1) / 2;
//         }
//         return result; 
//     }
// }


class Solution {
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
