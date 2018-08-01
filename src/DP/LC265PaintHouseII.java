package DP;

public class LC265PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) return 0;
        int row = costs.length;
        int col = costs[0].length;
        int[][] notPaint = new int[row + 1][col + 1];
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            int lastRow = i - 1;
            int curMin = Integer.MAX_VALUE;
            for (int j = 0; j < col; j++) {
                curMin = j == 0? curMin : Math.min(curMin, costs[lastRow][j - 1]);
                notPaint[i][j] = curMin;

            }
            for (int k = col - 1; k >= 0; k--) {
                curMin = k == col - 1? curMin : Math.min(curMin, costs[lastRow][k + 1]);
                notPaint[i][k] = curMin;

            }

            for (int m = 0; m < col; m++) {
                notPaint[i][m] += dp[lastRow][m];
            }

            for (int p = 0; p < col; p++) {
                dp[i][p] = notPaint[lastRow][p] + costs[i][p];
            }

        }

        //for (int[] arr : notPaint) System.out.println(Arrays.toString(arr));
        //for (int[] arr : dp) System.out.println(Arrays.toString(arr));
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            res = Math.min(res, dp[row][j]);
        }
        return res;
    }
}
