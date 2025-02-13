package com.keshav.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        int k = 3;
        int target = 7;
        System.out.println(combinationSum3(k, target));
    }

    private static List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] seen = new boolean[10];
        findCombinations3(1, k, target, new ArrayList<>(), res, seen);
        return res;
    }

    private static void findCombinations3(int start, int k, int target, List<Integer> sub, List<List<Integer>> res, boolean[] seen) {
        if (target == 0 && sub.size() == k) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (seen[i]) {
                return;
            }
            seen[i] = true;
            sub.add(i);
            findCombinations3(start + 1, k, target - i, sub, res, seen);
            seen[i] = false;
            sub.remove(sub.size() - 1);
        }

    }
}
