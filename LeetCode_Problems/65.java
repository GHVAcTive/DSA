class Solution {
    public boolean isNumber(String s) {
        s = s.trim(); // Remove leading/trailing whitespaces
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                numberSeen = true;
                if (eSeen) numberAfterE = true;

            } else if (ch == '.') {
                if (pointSeen || eSeen) return false;
                pointSeen = true;

            } else if (ch == 'e' || ch == 'E') {
                if (eSeen || !numberSeen) return false;
                eSeen = true;
                numberAfterE = false;

            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }

            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}
