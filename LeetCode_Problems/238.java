class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        // First pass: prefix products (left)
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Second pass: multiply with suffix products (right)
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
}
