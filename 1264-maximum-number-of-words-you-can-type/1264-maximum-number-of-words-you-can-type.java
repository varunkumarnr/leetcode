class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" "); 
        int result =0; 
        Set<Character> set = new HashSet<>(); 
        for(char c : brokenLetters.toCharArray()) { 
            set.add(c); 
        }
        for(String word : words) { 
            boolean present = false; 
            for(int i =0; i< word.length(); i++) { 
                if(set.contains(word.charAt(i))) {
                    present = true; 
                    break; 
                }     
            }
            if(!present) result++; 
        }
        return result;
    }
}