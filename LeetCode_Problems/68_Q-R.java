class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int gaps = last - index - 1;

            // If last line or single word line
            if (last == words.length || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) sb.append(" ");
                }
                int remaining = maxWidth - sb.length();
                while (remaining-- > 0) sb.append(" ");
            } else {
                int spaces = (maxWidth - totalChars + gaps) / gaps;
                int extra = (maxWidth - totalChars + gaps) % gaps;

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        for (int s = 0; s < spaces + (i - index < extra ? 1 : 0); s++) sb.append(" ");
                    }
                }
            }

            res.add(sb.toString());
            index = last;
        }

        return res;
    }
}
