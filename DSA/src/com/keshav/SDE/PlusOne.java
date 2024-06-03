package com.keshav.SDE;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {1, 2, 9};
        ;
        System.out.println(Arrays.toString(plusOne2(nums)));
    }

    static int[] plusOne2 (int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
            i -= 1;
        }
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    static void plusOne1 (int[] nums) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            str.append(nums[i]);
        }
        int num = Integer.parseInt(String.valueOf(str));
        num += 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (num > 0) {
            int last = num % 10;
            num /= 10;
            ans.add(last);
        }
        int[] newAns = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            newAns[i] = ans.get((ans.size() - 1) - i);
        }
        System.out.println(Arrays.toString(newAns));
    }
}
