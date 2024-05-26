package com.ArraysQuestions.Recursion;

public class PrintNumbers {
    public static void main(String[] args) {
        print(1);
    }

    static void print (int n) {
        if (n == 5) {
            System.out.println(n);
            return;
        }
        System.out.println(n);

        // Recursive call
        // if you are calling a function again and again, you can treat it as a separate call in the stack

        // this is called tail recursion
        // this is the last function call --> tail recursion
        print(n+1);
    }

}


