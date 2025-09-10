class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashSet<Integer> problematic = new HashSet<>();
        for (int[] connection : friendships) {
            int[] firstLanguage = languages[connection[0] - 1];
            int[] secondLanguage = languages[connection[1] - 1];
            if (!canCommunicate(firstLanguage, secondLanguage)) {
                problematic.add(connection[0]);
                problematic.add(connection[1]);
            }
        }
        if (problematic.isEmpty()) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int person : problematic) {
            int[] langs = languages[person - 1];
            for (int lang : langs) {
                map.put(lang, map.getOrDefault(lang, 0) + 1);
            }
        }

        int languageThatMostKnow = 0;
        int numberOfPeopleThatKnowit = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > numberOfPeopleThatKnowit) {
                numberOfPeopleThatKnowit = entry.getValue();
                languageThatMostKnow = entry.getKey();
            }
        }

        return problematic.size() - numberOfPeopleThatKnowit;
    }

    private boolean canCommunicate(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for (int lang : a) set.add(lang);
        for (int lang : b) {
            if (set.contains(lang)) return true;
        }
        return false;
    }
}
