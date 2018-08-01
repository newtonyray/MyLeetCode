package DP;

public class LC312BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                for (int k = i; k <= j; k++) {
                    int left = (k == i) ? 0 : dp[i][k - 1];
                    int right = (k == j) ? 0 : dp[k + 1][j];
                    int self = nums[k] * (i == 0 ? 1 : nums[i - 1]) * (j == len - 1 ? 1 : nums[j + 1]);
                    dp[i][j] = Math.max(dp[i][j], self + left + right);
                }
            }
        }
        return dp[0][len - 1];
    }
}
