package com.keshav.SDE.LeetDaily;

public class MaximumNumberOfFish {
    public static void main(String[] args) {
        int[][] grid = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        System.out.println(findMaxFish(grid));
    }

    static int m;
    static int n;
    private static int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        int[] curMax = new int[1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || grid[i][j] < 0) continue;
                dfs(i, j, grid, curMax);
                max = Math.max(max, curMax[0]);
                curMax[0] = 0;
            }
        }
        return max;
    }
    private static void dfs(int row, int col, int[][] grid, int[] max) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || grid[row][col] < 0) {
            return;
        }
        max[0] += grid[row][col];
        grid[row][col] = -grid[row][col];
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] d : dir) {
            int nRow = row + d[0];
            int nCol = col + d[1];
            dfs(nRow, nCol, grid, max);
        }
    }
}
