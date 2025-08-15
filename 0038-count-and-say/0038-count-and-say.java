class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String str = countAndSay(n-1); 
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < str.length();) {
            int count =0; 
            char curr  = str.charAt(i); 
            while(i< str.length() && str.charAt(i) == curr) {
                count++; 
                i++;
            } 
            sb.append(count).append(str.charAt(i - 1));
        } 
        System.out.println(sb.toString());
        return sb.toString(); 
    }
}