import java.util.*;

class Solution {
    private Set<String> visited;
    private StringBuilder result;
    private int k;
    private int n;

    public String crackSafe(int n, int k) {
        this.n = n;
        this.k = k;
        this.visited = new HashSet<>();
        this.result = new StringBuilder();

        StringBuilder start = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            start.append('0');
        }

        String startNode = start.toString();
        dfs(startNode);
        result.append(startNode);
        return result.toString();
    }

    private void dfs(String node) {
        for (int i = 0; i < k; i++) {
            String edge = node + i;
            if (!visited.contains(edge)) {
                visited.add(edge);
                dfs(edge.substring(1));
                result.append(i);
            }
        }
    }
}
