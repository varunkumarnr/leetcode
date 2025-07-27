class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length; 
        Arrays.sort(citations); // e.g., [0, 1, 3, 5, 6]
        int maxCitations = 0;  
        
        for (int i = 0; i < citations.length; i++) {
            int h = n - i; 
            if (citations[i] >= h) {
                maxCitations = h;
                break; 
            }
        }

        return maxCitations;
    }
}