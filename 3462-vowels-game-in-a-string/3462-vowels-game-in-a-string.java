class Solution {
    public boolean doesAliceWin(String s) {
        int countVowels = 0; 
        for(char c: s.toCharArray()) { 
            c = Character.toLowerCase(c); 
            if(c == 'a' || c== 'e' || c== 'i'|| c=='o' || c=='u') {
                return true;
            }
        }
        return false; 
        
    }
}