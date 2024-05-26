package com.ArraysQuestions.Recursion;

public class PrintNumbers {
    public static void main(String[] args) {
        print(1);
    }

    // Recursion --> Function calling itself.
    /* VIMP
        -> Why Recursion?
        - it helps us to solving bigger / complex problem in a simple way.
        - you can convert recursion solution into iteration and vice versa.
        - space complexity is not constant coz of recursive calls.
        - it helps us in breaking down bigger problems into smaller problems.
     */

    /* VVIMP
        -> How to understand and approach a problem
        1) identify if you can break bigger problem into smaller problem
        2) write the recursive relation if needed
        3) construct the recursive tree
        4) About the tree
            - see the flow of function, how they are getting in the stack.
            - identify and focus on left tree calls and right tree calls.
            - draw the tree and pointers again and again using pen and papers.
            - use debugger to see the flow.
        5) see how the values and what type of values (int, string etc) are returned at each step,
         see where the function call comes out of. In the end, you will come out the main function.
     */

    /* VVVVVVVVIMP
        -> Working with variables.
        1) Variables in - Arguments.
                        - Return type.
                        - in the middle of the body of function.

     */

    /*
        Types of Recurrence relations
        1) Linear recurrence relation --> eg: Fibonacci
        2) Divide and Conquer recurrence relation --> eg: Binary Search
     */

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


