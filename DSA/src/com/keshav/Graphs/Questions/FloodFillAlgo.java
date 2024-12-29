package com.keshav.Graphs.Questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgo {
    static int rows;
    static int cols;
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        rows = image.length;
        cols = image[0].length;
        int newColor = 2;
        int sr = 1, sc = 1;
//        dfs(sr, sc, image[sr][sc], newColor, image);
        bfs(sr, sc, image[sr][sc], newColor, image);
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
    // using dfs
    private static void dfs(int row, int col, int curColor, int newColor, int[][] image) {
        // out of bound & !curColor
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != curColor || image[row][col] == newColor) {
            return;
        }
        // mark new color
        image[row][col] = newColor;
        int[][] dir = {
                {row - 1, col}, {row, col + 1}, {row + 1, col}, {row, col - 1}
        };
        for (int[] neighbour : dir) {
            dfs(neighbour[0], neighbour[1], curColor, newColor, image);
        }
    }

    private static void bfs(int row, int col, int curColor, int newColor, int[][] image) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int r = queue.peek()[0];
            int c = queue.poll()[1];
            int[][] dir = {
                    {r - 1, c}, {r, c + 1}, {r + 1, c}, {r, c - 1}
            };
            // mark new color
            image[r][c] = newColor;
            // visit neighbours and mark new color
            for (int[] neighbour : dir) {
                int newRow = neighbour[0];
                int newCol = neighbour[1];
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || image[newRow][newCol] != curColor || image[newRow][newCol] == newColor) {
                    continue;
                }
                image[newRow][newCol] = newColor;
                queue.offer(new int[] {newRow, newCol});
            }
        }
    }
}
