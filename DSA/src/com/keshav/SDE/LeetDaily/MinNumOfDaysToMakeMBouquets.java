package com.keshav.SDE.LeetDaily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinNumOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(minDays(bloomDay, m , k));
    }

    static int minDays (int[] bloomDay, int m, int k) {

        int total = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int day : bloomDay) {
            set.add(day);
        }
        List<Integer> list = new ArrayList<>(set);
        int count = 0;
        for (int i=0;i<list.size();i++) {
            for (int j=0;j<bloomDay.length;j++) {
                if (list.get(i) == bloomDay[i]) {
                    count++;
                } else {
                    count=0;
                }
            }
            if (count == m) {
                total++;
                count = 0;
            }
            if (total >= m) {
                return 
            }
        }
    }
}
