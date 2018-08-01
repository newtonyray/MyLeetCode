package DFS;

import java.util.HashMap;
import java.util.HashSet;

public class LC827MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int res = 1;
        int len = grid.length;
        boolean[][] visited = new boolean[len][len];
        HashMap<Integer, Integer> sizeMap = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int ID = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len;j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    //visited[i][j] = true;
                    map.put(hashCode(i, j), ID);
                    int size = dfs(grid, visited, ID, map, i, j);
                    sizeMap.put(ID, size);
                    ID++;
                    res = Math.max(res, size);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len;j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, getSize(grid, i, j, sizeMap, map));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, boolean[][] visited, int ID, HashMap<Integer, Integer> map, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid.length || grid[row][col] == 0 || visited[row][col]) return 0;
        visited[row][col] = true;
        map.put(hashCode(row, col), ID);
        return 1
                + dfs(grid, visited, ID, map, row + 1, col)
                + dfs(grid, visited, ID, map, row, col + 1)
                + dfs(grid, visited, ID, map, row - 1, col)
                + dfs(grid, visited, ID, map, row, col - 1);
    }

    private int hashCode(int row, int col) {
        return (row + 1) * 17 + (col + 1) * 1700;
    }

    private int getSize(int[][] grid, int row, int col, HashMap<Integer, Integer> sizeMap, HashMap<Integer, Integer> map) {
        int[][] dirs = new int[][]{{0, 1},{1, 0},{0, -1},{-1, 0}};
        int res = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int[] d : dirs) {
            if (row + d[0] < 0 || row + d[0] >= grid.length || col + d[1] < 0 || col + d[1] >= grid.length
                    || grid[row + d[0]][col + d[1]] == 0) continue;
            int islandID = map.get(hashCode(row + d[0], col + d[1]));
            if (set.add(islandID)) res += sizeMap.get(islandID);
        }
        return res;
    }
}
