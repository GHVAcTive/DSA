import java.util.*;

// Mock implementation of NestedInteger for testing
class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    public NestedInteger(int value) {
        this.value = value;
    }

    public boolean isInteger() {
        return value != null;
    }

    public Integer getInteger() {
        return value;
    }

    public void setInteger(int value) {
        this.value = value;
        this.list = null;
    }

    public void add(NestedInteger ni) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.add(ni);
    }

    public List<NestedInteger> getList() {
        return list;
    }

    @Override
    public String toString() {
        if (isInteger()) return value.toString();
        return list.toString();
    }
}

class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.parseInt(s));

        Deque<NestedInteger> stack = new ArrayDeque<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(new NestedInteger());
                start = i + 1;
            } else if (c == ',' || c == ']') {
                if (i > start) {
                    int num = Integer.parseInt(s.substring(start, i));
                    stack.peek().add(new NestedInteger(num));
                }
                if (c == ']') {
                    if (stack.size() > 1) {
                        NestedInteger ni = stack.pop();
                        stack.peek().add(ni);
                    }
                }
                start = i + 1;
            }
        }

        return stack.isEmpty() ? new NestedInteger() : stack.pop();
    }
}

// Test driver
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "[123,[456,[789]]]";
        NestedInteger result = solution.deserialize(input);
        System.out.println(result); // Output: [123,[456,[789]]]
    }
}
