import java.util.*;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;

        path.add(node.val);
        sum -= node.val;

        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
        } else {
            dfs(node.left, sum, path, res);
            dfs(node.right, sum, path, res);
        }

        path.remove(path.size() - 1);
    }
}
