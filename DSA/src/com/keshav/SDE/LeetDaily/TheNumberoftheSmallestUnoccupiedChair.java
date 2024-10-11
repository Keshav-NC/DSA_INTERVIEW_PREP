package com.keshav.SDE.LeetDaily;

import java.util.*;

class TheNumberOfTheSmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        Arrays.sort (times, new Comparator<int[]>() {
            public int compare (int[] a, int[] b) {
                return a[0] - b[0]; // sort based on arrival time --> increasing order
            }
        });
        PriorityQueue<int[]> occupied = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare (int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> available = new PriorityQueue<>();
        int chairNo = 0;

        for (int[] time : times) {
            int arrivalTime = time[0];
            int leavingTime = time[1];

            while (!occupied.isEmpty() && occupied.peek()[0] <= arrivalTime) {
                available.offer (occupied.poll()[1]);
            }

            int currentChairNo;
            if (available.isEmpty()) {
                currentChairNo = chairNo;
                chairNo++;
            } else {
                currentChairNo = available.poll();
            }
            if (targetArrival == arrivalTime) return currentChairNo;
            occupied.offer (new int[] {leavingTime, currentChairNo});
        }
        return -1; // not reachable
    }
}