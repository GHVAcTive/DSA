class AllOne {
    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private Map<String, Node> map;

    public AllOne() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            Node nextNode = node.next;
            node.keys.remove(key);

            if (nextNode == tail || nextNode.count > node.count + 1) {
                Node newNode = new Node(node.count + 1);
                insertAfter(node, newNode);
                nextNode = newNode;
            }

            nextNode.keys.add(key);
            map.put(key, nextNode);

            if (node.keys.isEmpty()) remove(node);
        } else {
            Node nextNode = head.next;
            if (nextNode == tail || nextNode.count > 1) {
                Node newNode = new Node(1);
                insertAfter(head, newNode);
                nextNode = newNode;
            }

            nextNode.keys.add(key);
            map.put(key, nextNode);
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) return;

        Node node = map.get(key);
        node.keys.remove(key);

        if (node.count == 1) {
            map.remove(key);
        } else {
            Node prevNode = node.prev;
            if (prevNode == head || prevNode.count < node.count - 1) {
                Node newNode = new Node(node.count - 1);
                insertAfter(prevNode, newNode);
                prevNode = newNode;
            }

            prevNode.keys.add(key);
            map.put(key, prevNode);
        }

        if (node.keys.isEmpty()) remove(node);
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void insertAfter(Node node, Node newNode) {
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
