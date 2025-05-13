class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] candidate1 = null, candidate2 = null;

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] != v) {
                candidate1 = new int[] {parent[v], v};
                candidate2 = edge;
            } else {
                parent[v] = u;
            }
        }

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            if (edge == candidate2) continue;
            int u = edge[0], v = edge[1];
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            if (rootU == rootV) {
                return candidate1 != null ? candidate1 : edge;
            }
            parent[rootV] = rootU;
        }

        return candidate2;
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) parent[node] = find(parent, parent[node]);
        return parent[node];
    }
}
