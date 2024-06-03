package com.keshav.SDE;

public class HourGlass {
    public static void main(String[] args) {
        int[][] grid = {
                {6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}
        };
        System.out.println(hourGlass(grid));
    }
    static int hourGlass (int[][] grid) {
        int res = 0;
        for (int r=1;r<grid.length-1;r++) {
            for (int c=1;c<grid[0].length-1;c++) {
                int sum = grid[r-1][c-1] + grid[r-1][c] + grid[r-1][c+1]
                          + grid[r][c]
                          + grid[r+1][c-1] + grid[r+1][c] + grid[r+1][c+1];
                res = Math.max (sum, res);
            }
        }
        return res;
    }
}
