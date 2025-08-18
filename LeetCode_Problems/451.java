class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int[] count = new int[128];
        List<Character>[] buckets = new List[n + 1];
        for (char c : s.toCharArray())
            count[c]++;
        for (int i = 0; i < 128; ++i) {
            int freq = count[i];
            if (freq > 0) {
                if (buckets[freq] == null)
                    buckets[freq] = new ArrayList<>();
                buckets[freq].add((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int freq = n; freq > 0; --freq)
            if (buckets[freq] != null)
                for (char c : buckets[freq])
                    for (int i = 0; i < freq; ++i)
                        sb.append(c);
        return sb.toString();
    }
}
