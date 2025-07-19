class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String prev = "";

        for (String fol : folder) {
            if (prev.equals("") || !fol.startsWith(prev + "/")) {
                result.add(fol);
                prev = fol;
            }
        }
        return result;
    }
}
