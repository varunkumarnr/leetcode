class Solution {
    HashSet<Integer> set = new HashSet<>();
    
    public int totalNumbers(int[] digits) {
        backtracking(digits, 0, new StringBuilder(), new boolean[digits.length]);
        return set.size();
    }

    void backtracking(int[] digits, int start, StringBuilder curr, boolean[] visited) {
        int num = curr.toString().equals("") ? 0 : Integer.parseInt(curr.toString()); 
        if ( num >= 100) {
            if (num  % 2 ==0) {
                set.add(num);
            }
            return; 
        }
        for (int i = 0; i < digits.length; i++) {
            if(!visited[i]) {
                visited[i] = true; 
                curr.append(digits[i]);
                backtracking(digits, i + 1, curr, visited);
                curr.deleteCharAt(curr.length() - 1);
                visited[i] = false; 
            }
        }
    }
}