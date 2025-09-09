// class Solution {
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         int currentDate = 1; 
//         Queue<Integer> hold = new LinkedList<>(); 
//         Queue<Integer> active = new LinkedList<>();
//         if(delay == 0) { 
//             active.offer(currentDate); 
//         }  else {
//             hold.offer(currentDate); 
//         }
//         while(currentDate <= n) {
//             while(!hold.isEmpty() && currentDate - hold.peek() >= delay) {
//                 int curr = hold.poll(); 
//                 active.offer(curr); 
//             }
//             while(!active.isEmpty() && currentDate - active.peek() >= forget) { 
//                 active.poll(); 
//             }
//             long activeSize = active.size(); 
//             while(activeSize > 0) {
//                 hold.offer(currentDate); 
//                 activeSize--; 
//             }
//             currentDate++; 
//         }
//         return (int) ((long)active.size() + (long)hold.size()) % 1000000007;
//     }
// }

class Solution { 
    /* 
       0 1 1 2 3 3 5
    */ 
    public int peopleAwareOfSecret(int n, int delay, int forget) { 
        long[] dp = new long[n+1]; 
        dp[0] = 0; 
        dp[1] = 1; 
        for(int i=2; i<=n; i++) {
            int todaysPeople = 0 ; 
            if(i<=delay) { 
                continue; 
            } 
            // need to add yesterdays count than count of new users who can share + remve users that forget
            if(i <= forget) {
                for(int j = 0 ; j <i; j++) {
                        if(i - j >= delay) { 
                            dp[i] += dp[j];
                        }
                }
            } else {
                for(int j = (i - (forget-1)); j <i; j++) {
                if(i - j >= delay) {
                    dp[i] += dp[j];
                }
            }
            }
        }
        System.out.println(Arrays.toString(dp));
        long total = 0; 
        for(int i = (n+1) - (forget); i<=n ;i++) { 
            total += dp[i]; 
        }
        return (int) total % 1000000007;
    } 
}