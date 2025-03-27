import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // Return empty list if root is null
        if (root == null) {
            return result;
        }

        // Create a queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Level order traversal using BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at current level

            // Iterate through the nodes at this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // If it's the last node of this level, add it to the result
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                // Add left child if exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // Add right child if exists
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return result;
    }
}
