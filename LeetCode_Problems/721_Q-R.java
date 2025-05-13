import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                parent.put(account.get(i), account.get(i));
                emailToName.put(account.get(i), name);
            }
        }

        for (List<String> account : accounts) {
            String root = find(parent, account.get(1));
            for (int i = 2; i < account.size(); i++) {
                parent.put(find(parent, account.get(i)), root);
            }
        }

        for (List<String> account : accounts) {
            String root = find(parent, account.get(1));
            unions.computeIfAbsent(root, x -> new TreeSet<>()).addAll(account.subList(1, account.size()));
        }

        List<List<String>> result = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> merged = new ArrayList<>(unions.get(root));
            merged.add(0, emailToName.get(root));
            result.add(merged);
        }
        return result;
    }

    private String find(Map<String, String> parent, String s) {
        return parent.get(s).equals(s) ? s : find(parent, parent.get(s));
    }
}
