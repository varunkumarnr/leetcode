class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        /* 
            store all strings of wordlist in a set 
            look through the queries
                check exact match --> add to array 
                check case ignore match --> add first occ to array
                hashMap 
        */
        
        HashSet<String> set = new LinkedHashSet<>();
        HashMap<String, String> caseLookup = new LinkedHashMap<>();
        HashMap<String, String> vowelsLookUp = new LinkedHashMap<>(); 
        String[] result = new String[queries.length]; 
        
        for (String word : wordlist) {
            set.add(word); 
            if(!caseLookup.containsKey(word.toLowerCase())) {
                caseLookup.put(word.toLowerCase(), word); 
            }
            StringBuffer sb = new StringBuffer(); 
            for (char c : word.toLowerCase().toCharArray()) {
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    sb.append(c); 
                } else {
                    sb.append('_');
                }
            }
            if(!vowelsLookUp.containsKey(sb.toString().toLowerCase())) {
                vowelsLookUp.put(sb.toString().toLowerCase(), word); 
            }
        }
        
        for (int i = 0; i < queries.length; i++) { 
            String s = queries[i]; 
            StringBuffer sb = new StringBuffer(); 
            for (char c : s.toLowerCase().toCharArray()) {
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    sb.append(c); 
                } else {
                    sb.append('_');
                }
            }
            if (set.contains(s)) {
                result[i] = s; 
            } else if (caseLookup.containsKey(s.toLowerCase())) {
                result[i] = caseLookup.get(s.toLowerCase()); 
            } else if (vowelsLookUp.containsKey(sb.toString().toLowerCase())) { 
                result[i] = vowelsLookUp.get(sb.toString().toLowerCase());
            } else { 
                result[i] = ""; 
            }
        }
        return result; 
    }
}