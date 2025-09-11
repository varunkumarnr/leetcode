class Solution {
    public String sortVowels(String s) {
        // store all vowels positions in list 
        // store all vowels in list 
        //  sort the vowels list 
        // add consents in origianl position and vowels in sorted positions in string builder 
        // return string builder to string. 

        if(s.equals("")) return s; 
        List<Integer> pos = new ArrayList<>(); 
        List<Character> vowels = new ArrayList<>(); 
        for(int i =0; i< s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i)); 
            if( c == 'a' || c== 'e' || c== 'i' || c=='o' || c=='u') {
                vowels.add(s.charAt(i));
                pos.add(i); 
            }
        }
        Collections.sort(vowels); 
        StringBuilder sb = new StringBuilder();
        int pos_counter  = 0;  
        for(int i = 0; i<s.length(); i++) {
            if(pos_counter < pos.size() && pos.get(pos_counter) == i) { 
                sb.append(vowels.get(pos_counter));
                pos_counter++; 
            } else {
                sb.append(s.charAt(i)); 
            }
        }
        return sb.toString(); 
    }
}