class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>(); 
        int closecounter = 0; 
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i); 
            } else if(s.charAt(i) == ')') {
                if(stack.size() ==0) {
                    closecounter++;
                    continue; 
                }
                int idx =  stack.pop(); 
                System.out.println(idx);
                sb.append(')');
                sb.insert(idx - stack.size() - closecounter, '(');
            } else {
                sb.append(s.charAt(i));
            }
         }
         return sb.toString(); 
    }
}