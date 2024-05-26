package com.ArraysQuestions.Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            System.out.print(fibFormula(i) + " ");
        }
//        System.out.println(fibFormula(3));
    }

    // Golden Ratio

    static int fibFormula (int n) {
        //                                                     less dominating term, so ignore it
        return (int) ((Math.pow(((1 + Math.sqrt(5)) / 2),n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5)) ;
//        return (int) (Math.pow((1+Math.sqrt(5))/2, n) / Math.sqrt(5));
    }



    //                                                  LHS         RHS
    // Recurrence relation of Fibonacci --> Fib (N) = Fib (N-1) + Fib (N-2).

    static int fibonacci (int num) {
        // Base Condition
        if (num == 0 || num == 1) {
            return num;
        }

        // this is not tail recursion --> coz its doing additional task --> its adding two numbers and returning ans
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

}
