package com.ArraysQuestions.BinarySearching;

import java.util.Scanner;

public class BankTotal {
    public static void main(String[] args) {
        int[][] accounts = {
                {1, 2, 3},
                {3, 2, 1}
        };
        Scanner in = new Scanner(System.in);
//        for (int row = 0; row < accounts.length; row++) {
//            for (int col = 0; col < accounts[row].length; col++) {
//                accounts[row][col] = in.nextInt();
//            }
//        }
        int ans = maxWealth(accounts);
        System.out.println(ans);

    }
    static int maxWealth(int[][] accounts) {
        //row --> person
        //col --> account
        int max = Integer.MIN_VALUE;

        for (int person = 0; person < accounts.length; person++) {
            int sum = 0;// reset sum for each row
            for (int account = 0; account < accounts[person].length; account++) {
                sum += accounts[person][account];
            }

            if (sum > max) max = sum;
        }
;        return max;
    }

}
