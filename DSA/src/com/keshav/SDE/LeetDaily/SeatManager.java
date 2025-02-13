package com.keshav.SDE.LeetDaily;

import com.sun.source.tree.Tree;

import javax.management.RuntimeErrorException;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.concurrent.RunnableScheduledFuture;

public class SeatManager {
    PriorityQueue<Integer> minHeap;
    int num = 1;
    public SeatManager(int n) {
        minHeap = new PriorityQueue<>();
    }
    public int reserve() {
        if (minHeap.isEmpty()) {
            return num++;
        }
        return minHeap.poll();
    }
    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
    }

    public static void main(String[] args) {
//        ["SeatManager","reserve","unreserve","reserve","reserve",
//        "reserve","unreserve","reserve","unreserve","reserve","unreserve"]
//        [[4],[],[1],[],[],[],[2],[],[1],[],[2]]
//        [null,1,null,1,2,3,null,2,null,1,null]
        SeatManager obj = new SeatManager(4);
        System.out.println(obj.reserve());
        obj.unreserve(1);
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        obj.unreserve(2);
        System.out.println(obj.reserve());
        obj.unreserve(1);
        System.out.println(obj.reserve());
        obj.unreserve(2);
    }
}
