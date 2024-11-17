package com.keshav.BinarySearching.BinarySearchOnAnswer;

import jdk.jshell.spi.SPIResolutionException;

import java.util.*;

class Item implements Comparable<Item> {
    int price = 0;
    int beauty = 0;

    public Item(int price, int beauty) {
        this.price = price;
        this.beauty = beauty;
    }
    @Override
    public int compareTo(Item that) {
        return that.price - this.price;
    }

    @Override
    public String toString() {
        return ("(Price : " + this.price + " ,Beauty : " + this.beauty + "), \n");
    }
}
public class MostBeautifulItemQuery {
    public static void main(String[] args) {
//        int[][] items = {{1, 2}, {1, 1}, {2, 4}, {2, 3}, {4, 2}, {4, 1}};
        int[][] items = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries = {1, 2, 3, 4, 5, 6};
//        System.out.println(Arrays.toString(maximumBeauty(items, queries)));
        PriorityQueue<Item> maxHeap = new PriorityQueue<>();
        for (int[] row : items) {
            int price = row[0];
            int beauty = row[1];
            Item obj = new Item(price, beauty);
            maxHeap.offer(obj);
        }
        List<Integer> ans = new ArrayList<>();
        int i = queries.length;
        while (!maxHeap.isEmpty()) {
            int p = maxHeap.peek().price;
            if (i > 0 && p < queries[--i]) {
                ans.add(maxHeap.peek().beauty);
            } else {
                maxHeap.poll();
            }
        }
        System.out.println(ans);
    }

    private static int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[0] - b[0]);
            }
        });
        System.out.println(Arrays.deepToString(items));
        return ans;
    }
    public static int search(int[][] items, int query) {
        int start = 0;
        int end = items.length - 1;
        int max = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int price = items[mid][0];
            int beauty = items[mid][1];
            if (query >= price) {
                max = Math.max(max, beauty);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return max;
    }
}
