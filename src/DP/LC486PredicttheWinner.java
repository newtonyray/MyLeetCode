package DP;

public class LC486PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1 || nums.length % 2 == 0) return true;
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                int left = (j - 2 < 0) ? 0 : dp[i][j - 2];
                int mid = (j - 1 < 0 || i + 1 >= len) ? 0 : dp[i + 1][j - 1];
                int right = (i + 2 >= len) ? 0 : dp[i + 2][j];
                dp[i][j] = Math.max(nums[i] + Math.min(mid, right), Math.min(left, mid) + nums[j]);
            }
        }
        int sum = 0;
        for (int num : nums) sum += num;
        return dp[0][len - 1] * 2 >= sum;
    }
}
