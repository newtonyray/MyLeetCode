package DFS;

public class LC132PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) return 0;
        int len = s.length();
        boolean[][] isPam = new boolean[len][len];
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) dp[i] = len - i - 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || isPam[i + 1][j - 1])) {
                    isPam[i][j] = true;
                    dp[i] = j == len - 1? 0 : Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }
}
