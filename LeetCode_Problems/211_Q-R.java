class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (char x = 'a'; x <= 'z'; x++) {
                    if (node.containsKey(x) && searchInNode(word.substring(i + 1), node.get(x))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
            }
        }
        return node.isEnd();
    }

    private class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
