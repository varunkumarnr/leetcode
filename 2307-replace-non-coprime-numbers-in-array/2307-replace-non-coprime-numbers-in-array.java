class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result=  new ArrayList<>(); 
        if(nums.length == 0) return result; 
        stack.push(nums[0]); 
        for(int i = 1; i<nums.length; i++) { 
            boolean isValid = true; 
            stack.push(nums[i]); 
            while(!stack.isEmpty() && isValid) {
                int latest = stack.pop(); 
                if(stack.isEmpty()) { 
                    isValid = false; 
                    stack.push(latest);
                    continue; 
                }
                int curr = stack.peek(); 
                int gcd  = GCD(curr, latest); 
                if(gcd > 1) { 
                    stack.pop(); 
                    stack.push(LCM(curr, latest, gcd)); 
                } else { 
                    stack.push(latest); 
                    isValid =false; 
                }
            }
        }
        while(!stack.isEmpty()) {
            result.add(stack.pop()); 
        }
        List<Integer> revResult = new ArrayList<>();
        for(int i = result.size()-1; i>=0;i--) {
            revResult.add(result.get(i)); 
        }
        return revResult; 
    }
     int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    int LCM(int a, int b, int gcd) {
        return (a / gcd) * b;  
    }
}