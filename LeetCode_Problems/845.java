class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        int i = 1;

        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i;
                int right = i;

                // Expand to the left
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Expand to the right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
                i = right;
            } else {
                i++;
            }
        }
        return maxLen;
    }
}
