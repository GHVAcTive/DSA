import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
    
    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

class Solution {
    private Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        // If node is already cloned, return the clone
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        // Clone the node and store it in the map
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        // Clone all the neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }
}
