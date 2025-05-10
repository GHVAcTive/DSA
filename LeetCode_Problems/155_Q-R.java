import java.util.*;

public class Solution {

    public String larrysArray(List<Integer> A) {
        int inversions = 0;

        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) > A.get(j)) {
                    inversions++;
                }
            }
        }

        return (inversions % 2 == 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> A = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                A.add(sc.nextInt());
            }

            Solution solution = new Solution();
            System.out.println(solution.larrysArray(A));
        }
        sc.close();
    }
}
