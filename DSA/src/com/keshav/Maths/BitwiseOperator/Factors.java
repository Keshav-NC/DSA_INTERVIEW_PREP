package com.keshav.Maths.BitwiseOperator;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        int num = 27;
//        simpleFactors(num);
        factors(num);

    }
    static void simpleFactors (int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.println(i+ " ");
            }
        }
    }

    static void factors (int num) {
        ArrayList<Integer> num2 = new ArrayList<>();
        for (int i = 1; i < num/i; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
                num2.add(num / i);
            }
        }
        for (int i = num2.size()-1; i >= 0; i--) {
            System.out.print(num2.get(i) + " ");
        }
    }
}
