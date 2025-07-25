// class Solution {
//     int count = 0; 
//     public int climbStairs(int n) {
//         HashMap<Integer,Interger> map = new HashMap<>(); 
//         climb(0, n, map);
//         return count;  
//     }
//     public void climb(int current, int n, HashMap<Integer,Interger> map) {
//         if(current > n) { 
//             return; 
//         }
//         if(current == n) {
//             count++;
//         } 
//         climb(current+1, n); 
//         climb(current+2, n); 
//     }
// }


class Solution { 
    HashMap<Integer, Integer> memo = new  HashMap<>();
    public int climbStairs(int n) { 
       return climb(n);
    }
    int climb(int n) {
        if(memo.containsKey(n)) return memo.get(n); 
        
        if(n==0 || n== 1){
            return 1; 
        }
        int result = climb(n-1) + climb(n-2); 
        memo.put(n, result);
        return result; 
    }
}