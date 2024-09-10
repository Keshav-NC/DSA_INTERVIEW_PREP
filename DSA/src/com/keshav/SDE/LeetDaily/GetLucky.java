package com.keshav.SDE.LeetDaily;

// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/?envType=daily-question&envId=2024-09-03
public class GetLucky {
    public static void main(String[] args) {
        String s = "abchiiaxidyz";
        int k = 2;
        System.out.println(getLucky(s, k));
    }

    private static int getLucky(String s, int k) {
        int totalSum = 0;

        for (char ch : s.toCharArray()) {
            int charIndex = (ch - 'a') + 1;
            while (charIndex > 0) {
                totalSum += charIndex % 10;
                charIndex /= 10;
            }
        }
        for (int i = 0; i < k-1; i++) {
            int sum = 0;
            while (totalSum > 0) {
                sum += totalSum % 10;
                totalSum /= 10;
            }
            totalSum = sum;
        }

        return totalSum;
    }
}
