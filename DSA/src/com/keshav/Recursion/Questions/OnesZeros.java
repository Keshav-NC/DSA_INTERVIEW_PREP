package com.keshav.Recursion.Questions;

import java.util.ArrayList;
import java.util.List;

public class OnesZeros {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(nBitBinary(n));
    }

    private static List<String> nBitBinary(int n) {
         List<String> ans = new ArrayList<>();
         solve("", n, ans, 0, 0);
         return ans;
    }

    private static void solve(String bits, int n, List<String> ans, int ones, int zeros) {
        if (n == 0) {
            ans.add(bits);
            return;
        }
        solve(bits + "1", n - 1, ans, ones + 1, zeros);
        if (zeros < ones) {
            solve(bits + "0", n - 1, ans, ones, zeros + 1);
        }
    }
}
