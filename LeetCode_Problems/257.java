class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node.left == null && node.right == null) {
            paths.add(path + node.val);  // Leaf node → complete path
            return;
        }

        if (node.left != null)
            dfs(node.left, path + node.val + "->", paths);

        if (node.right != null)
            dfs(node.right, path + node.val + "->", paths);
    }
}
