class Solution {
    List<StringBuilder> result = new ArrayList<>();
    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        for(int i =1; i<=n; i++) {
            s.append((char)('0' + i));
        }
        backtracking(s, new StringBuilder(),k, new boolean[n]);
        return result.get(k-1).toString(); 
    }
    void backtracking(StringBuilder str, StringBuilder curr, int k,  boolean[] used) {
        if(result.size() > k) {
            return; 
        }
        if(curr.length() == str.length()) {    
            result.add(new StringBuilder(curr));
            return; 
        }
        for(int i = 0; i<str.length(); i++) {
            if(used[i]) continue;
            used[i] = true;
            curr.append(str.charAt(i)); 
            backtracking(str, curr,k, used); 
            curr.deleteCharAt(curr.length()-1);
            used[i] = false; 
        }
    }
}