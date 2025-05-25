class LFUCache {
    class Node {
        int key, val, freq;
        Node(int k, int v) {
            key = k;
            val = v;
            freq = 1;
        }
    }

    int capacity, minFreq;
    Map<Integer, Node> nodeMap;
    Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if (nodeMap.size() >= capacity) {
                int evictKey = freqMap.get(minFreq).iterator().next();
                freqMap.get(minFreq).remove(evictKey);
                nodeMap.remove(evictKey);
            }

            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        freqMap.get(freq).remove(node.key);
        if (freq == minFreq && freqMap.get(freq).isEmpty()) minFreq++;

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node.key);
    }
}
