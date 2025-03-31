import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if the current string length equals 2 * n, add it to the result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // If the number of open parentheses is less than n, add an open parenthesis
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // If the number of closed parentheses is less than open, add a close parenthesis
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
