package com.keshav.Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ++freshCount;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (freshCount == 0) return 0;
        int time = 0;
        for (;!queue.isEmpty(); ++time) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] rotten = queue.poll();
                int row = rotten[0];
                int col = rotten[1];
                int[][] neighbours = {
                        {row - 1, col}, {row, col + 1}, {row + 1, col}, {row, col - 1}
                };
                for (int[] neighbour : neighbours) {
                    int nRow = neighbour[0];
                    int nCol = neighbour[1];
                    // out of bound / visited / rotten
                    if (nRow < 0 || nRow >= n || nCol < 0 || nCol >= m || grid[nRow][nCol] == 0 || grid[nRow][nCol] == 2) {
                        continue;
                    }
                    grid[nRow][nCol] = 2; // visited
                    queue.offer(new int[]{nRow, nCol});
                    --freshCount;
                    if (freshCount == 0) {
                        return time + 1;
                    }
                }
            }
//            freshCount -= queue.size();
        }
        return  (freshCount == 0) ? time : -1;
    }
}
