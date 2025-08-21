class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, new ArrayList<>(), 0); 
        return result; 
    }
    void backtracking(String s, List<String> now, int start) {
        if (start == s.length()) { 
            result.add(new ArrayList<>(now));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                now.add(s.substring(start, i + 1));
                backtracking(s, now,  i + 1);          
                now.remove(now.size() - 1);       
            }
    }
    }


    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}