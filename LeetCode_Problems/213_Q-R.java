public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // Two cases: rob from 0 to n-2 or 1 to n-1
        return Math.max(robHelper(nums, 0, nums.length - 2), 
                        robHelper(nums, 1, nums.length - 1));
    }

    private int robHelper(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;

        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev2 = temp;
        }

        return prev1;
    }
}
