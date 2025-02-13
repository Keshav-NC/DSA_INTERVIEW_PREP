package com.keshav.Recursion.Backtracking;

import java.awt.dnd.DropTarget;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {1,2,3};
        int target = 4;
        System.out.println(combinationSum(candidates, target));
    }
    static int n;

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(0, 0, candidates, target, res, new ArrayList<>());
        return res;
    }

    private static void findCombinations(int start, int sum, int[] candidates, int target, List<List<Integer>> res, List<Integer> sub) {
        if (start == n) {
            return;
        }
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(sub));
            return;
        }
        for (int i = start; i < n; i++) {
            sub.add(candidates[i]);
            findCombinations(i, sum + candidates[i], candidates, target, res, sub);
            sub.remove(sub.size() - 1);
        }
    }
}
