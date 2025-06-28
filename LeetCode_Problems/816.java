class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        String str = s.substring(1, s.length() - 1);

        for (int i = 1; i < str.length(); i++) {
            List<String> left = generateNumbers(str.substring(0, i));
            List<String> right = generateNumbers(str.substring(i));
            for (String l : left) {
                for (String r : right) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }

    private List<String> generateNumbers(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        if (n == 1 || s.charAt(0) != '0') result.add(s);
        if (n > 1 && s.charAt(0) == '0' && s.charAt(n - 1) != '0') {
            result.add("0." + s.substring(1));
        } else if (s.charAt(0) != '0' && s.charAt(n - 1) != '0') {
            for (int i = 1; i < n; i++) {
                result.add(s.substring(0, i) + "." + s.substring(i));
            }
        }
        return result;
    }
}
