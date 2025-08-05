class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for (int left = 0; left < n; left++) {
            int[] rowSum = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][right];
                }
                res = Math.max(res, maxSumSubArray(rowSum, k));
                if (res == k) return res; // Early exit if exact match found
            }
        }
        return res;
    }

    private int maxSumSubArray(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int num : nums) {
            sum += num;
            Integer ceiling = set.ceiling(sum - k);
            if (ceiling != null) {
                max = Math.max(max, sum - ceiling);
            }
            set.add(sum);
        }
        return max;
    }
}
