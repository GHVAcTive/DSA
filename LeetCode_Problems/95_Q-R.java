import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTreesInRange(1, n);
    }

    private List<TreeNode> generateTreesInRange(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Loop through each number in the range as the root
        for (int i = start; i <= end; i++) {
            // Generate all left and right subtrees
            List<TreeNode> leftTrees = generateTreesInRange(start, i - 1);
            List<TreeNode> rightTrees = generateTreesInRange(i + 1, end);

            // Combine left and right subtrees with the current root
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentRoot = new TreeNode(i);
                    currentRoot.left = left;
                    currentRoot.right = right;
                    allTrees.add(currentRoot);
                }
            }
        }
        return allTrees;
    }
}
