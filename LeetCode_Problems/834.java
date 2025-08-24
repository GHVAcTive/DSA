class Solution {
    int[] res;
    int[] count;
    List<Set<Integer>> tree;
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<>();
        for (int i = 0; i < N; ++i) tree.add(new HashSet<>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        
        res = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);
        
        dfs(0, -1);
        dfs2(0, -1);
        
        return res;
    }
    
    public void dfs(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            dfs(child, node);
            count[node] += count[child];
            res[node] += res[child] + count[child];
        }
    }
    
    public void dfs2(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            res[child] = res[node] - count[child] + (count.length - count[child]);
            dfs2(child, node);
        }
    }
}
