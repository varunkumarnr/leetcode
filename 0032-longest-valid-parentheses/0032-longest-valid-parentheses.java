class Solution {
    public int longestValidParentheses(String s) {
        int end = 0; 
        int[] dp = new int[s.length()]; 
        while(end < s.length()) {
            Stack<Object[]> stack  = new Stack<>();  
            boolean valid = true;
            while(end < s.length() && valid) { 
                if(s.charAt(end) == '(') { 
                    stack.push(new Object[]{'(', end}); 
                    end++; 
                } else if(!stack.isEmpty() && s.charAt(end) ==')') { 
                    Object[] curr = stack.pop(); 
                    dp[end] = 1;
                    end++;
                    dp[(int) curr[1]] = 1; 
                } else if(stack.isEmpty() && s.charAt(end) ==')') {
                    valid = false; 
                    end++;  
                }
            }
        }
        // sliding window on dp array count max consicutive once 
        int left = 0; 
        int right = 0;
        int max = 0; 
        while(right < dp.length) { 
            while(right < dp.length && dp[right] ==1) { 
                right++; 
            }
            max = Math.max(max, right - left); 
            left = right + 1; 
            right++; 
        } 

        return max; 
    }
}