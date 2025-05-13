class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) parent[i] = i;

        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 == root2) return edge;
            parent[root1] = root2;
        }
        return new int[0];
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) parent[node] = find(parent, parent[node]);
        return parent[node];
    }
}
