package com.keshav.SlidingWindow;

import javax.imageio.ImageTranscoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }

    private static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int baskets = 2; // given in question
        HashMap<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int end = 0;
        int total = 0;

        while (end < n) {
            int fruit = fruits[end];
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);

            if (freq.size() == baskets) {
                total = Math.max(total, end - start + 1);
            } else if (freq.size() > baskets) {
                while (start < end && freq.size() > baskets) {
                    fruit = fruits[start];
                    int fruitFreq = freq.get(fruit);
                    --fruitFreq;
                    if (fruitFreq == 0) {
                        freq.remove(fruit);
                    } else {
                        freq.put(fruit, fruitFreq);
                    }
                    ++start;
                }
            }
            ++end;
        }
        return total;
    }
}
