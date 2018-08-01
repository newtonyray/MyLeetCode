package DFS;

public class LC329LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int maxLen = 1;
        int[][] mem = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, mem, Integer.MIN_VALUE, i, j));
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int[][]mem, int prevVal, int row, int col) {
        if (row >= matrix.length || row < 0 || col > matrix[0].length || col < 0
                || matrix[row][col] <= prevVal) return 0;
        if (mem[row][col] != 0) return mem[row][col];
        int res = 1;
        int[][] dirs = new int[][]{{0, 1},{1, 0},{0, -1},{-1, 0}};
        for (int[] d : dirs) {
            int newRow = d[0] + row;
            int newCol = d[1] + col;
            res = Math.max(res, 1 + dfs(matrix, mem, matrix[newRow][newCol], newRow, newCol));
        }
        mem[row][col] = res;
        return res;
    }
}
