class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(!isClosed(c)) stack.add(c);
            if(isClosed(c)) {
                if(stack.isEmpty()) return false;
                char curr = stack.pop(); 
                if((curr == '(' && c != ')') || (curr == '[' && c!=']') || (curr == '{' && c!='}')) {
                    return false;
                }
            }
        } 
        return stack.isEmpty() ? true : false; 
    }
    boolean isClosed(char c) { 
        if(c == '}' || c == ']' || c == ')') return true;
        return false;  
    }
}