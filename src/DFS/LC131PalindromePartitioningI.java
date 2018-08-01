package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC131PalindromePartitioningI {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        dfs(res, new ArrayList<String>(), s, new boolean[s.length()][s.length()], 0);
        return res;

    }

    private void dfs(List<List<String>> res, List<String> list, String s, boolean[][] isPam, int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList<String>(list));
        }
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(idx) && (i - idx < 3 || isPam[idx + 1][i - 1])) {
                isPam[idx][i] = true;
                list.add(s.substring(idx, i + 1));
                dfs(res, list, s, isPam, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
