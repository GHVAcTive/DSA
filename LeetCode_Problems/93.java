class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, "", 0, result);
        return result;
    }

    private void backtrack(String s, int index, String currentIP, int segmentCount, List<String> result) {
        if (segmentCount > 4) return;
        if (segmentCount == 4 && index == s.length()) {
            result.add(currentIP.substring(0, currentIP.length() - 1)); // remove last dot
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String segment = s.substring(index, index + len);
            if (isValidSegment(segment)) {
                backtrack(s, index + len, currentIP + segment + ".", segmentCount + 1, result);
            }
        }
    }

    private boolean isValidSegment(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}
