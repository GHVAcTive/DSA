class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words)
            count.put(word, count.getOrDefault(word, 0) + 1);
        PriorityQueue<String> heap = new PriorityQueue<>(
            (a, b) -> count.get(a).equals(count.get(b)) ? a.compareTo(b) : count.get(b) - count.get(a)
        );
        heap.addAll(count.keySet());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(heap.poll());
        return res;
    }
}
