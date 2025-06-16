class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordSet.contains(endWord)) return result;

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, wordSet, graph, distance);
        List<String> path = new ArrayList<>();
        dfs(endWord, beginWord, graph, distance, path, result);

        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        for (String word : wordSet) {
            graph.put(word, new ArrayList<>());
        }
        graph.put(beginWord, new ArrayList<>());

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currDist = distance.get(current);

            for (String neighbor : getNeighbors(current, wordSet)) {
                graph.get(neighbor).add(current);
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, currDist + 1);
                    queue.offer(neighbor);
                }
            }
        }
    }

    private void dfs(String current, String beginWord, Map<String, List<String>> graph, Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        path.add(current);
        if (current.equals(beginWord)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            result.add(copy);
        } else {
            for (String prev : graph.get(current)) {
                if (distance.get(prev) + 1 == distance.get(current)) {
                    dfs(prev, beginWord, graph, distance, path, result);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chArr = word.toCharArray();

        for (int i = 0; i < chArr.length; i++) {
            char originalChar = chArr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                chArr[i] = c;
                String newWord = new String(chArr);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            chArr[i] = originalChar;
        }

        return neighbors;
    }
}
