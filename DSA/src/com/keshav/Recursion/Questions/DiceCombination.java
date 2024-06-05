package com.keshav.Recursion.Questions;

import java.util.ArrayList;
import java.util.List;

public class DiceCombination {
    public static void main(String[] args) {
//        dice("", 4);
        System.out.println(diceAL("", 7));
    }
    // pattern processed and unprocessed
    static void dice (String p, int target) {
        if (target == 0) {
            System.out.print(p + " ");
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    static List<String> diceAL (String p, int target) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target ; i++) {
            list.addAll( diceAL(p + i, target - i));
        }
        return list;
    }
}
