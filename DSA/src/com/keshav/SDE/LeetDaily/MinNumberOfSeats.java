package com.keshav.SDE.LeetDaily;

import java.util.Arrays;

public class MinNumberOfSeats {
    public static void main(String[] args) {
        int[] seats = {3, 1, 5};
        int[] students = {2, 7, 4};

        System.out.println(minSeat(seats, students));
    }


    // Greedy Approach
    static int minSeat (int[] seats, int[] students) {
        int minMoves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i=0;i<seats.length;i++) {
            minMoves += Math.abs (seats[i] - students[i]);
        }
        return minMoves;
    }
}
