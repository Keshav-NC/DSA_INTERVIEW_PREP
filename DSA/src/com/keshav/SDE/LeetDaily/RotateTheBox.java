package com.keshav.SDE.LeetDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateTheBox {
    public static void main(String[] args) {

        char[][] box = {{'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}};
        int[] nums = new int[8];
        List<int[]> list = Arrays.asList(nums);
//        System.out.println(Arrays.deepToString(box));
//        System.out.println(Arrays.deepToString(rotateBox(box)));
    }

    private static char[][]rotateBox(char[][] box) {

        for (int i = 0; i < box.length; i++) {
            int curr = box[0].length - 1;
            int prev = box[0].length - 1;
            while (curr >= 0) {
                if (box[i][curr] == '#' && box[i][prev] == '.' || box[i][curr] == '.' && box[i][prev] == '#') {
                    swap(box, i, curr,prev);
                    --curr;
                    --prev;
                } else if (box[i][curr] == '.' || box[i][curr] == '#') {
                    --curr;
                } else if (box[i][curr] == '*') {
                    --curr;
                    prev = curr;
                }
            }
        }
        int rows = box.length;
        int cols = box[0].length;
        char[][] t = new char[box[0].length][box.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t[j][rows - 1 - i] = box[i][j];
            }
        }
        return t;
    }

    private static void swap(char[][] box, int rowInd, int i, int j) {
        char temp = box[rowInd][i];
        box[rowInd][i] = box[rowInd][j];
        box[rowInd][j] = temp;
    }
}
