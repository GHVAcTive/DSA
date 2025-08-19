import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int third = Integer.MIN_VALUE;  // candidate for "2" in 132
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true; // found 132
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                third = stack.pop(); // update "2"
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
