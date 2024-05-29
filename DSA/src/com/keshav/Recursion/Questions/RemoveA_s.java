package com.keshav.Recursion.Questions;

public class RemoveA_s {
    public static void main(String[] args) {
        String str = "baappledfg";
        System.out.println(skip(str));
    }

    static String skip(String str) {
//        return helperWithAnsArgs("", str);
        return helperApple (str);
    }

    // Note : str.substring --> skips the first from till the mentioned index characters

    static String helperWithAnsArgs(String ans, String str) {
        if (str.isEmpty()) {
            return ans;
        }

        if (str.charAt(0) == 'a') {
           return helperWithAnsArgs(ans, str.substring(1));
        }

        return helperWithAnsArgs(ans + str.charAt(0), str.substring(1));
    }

    static  String helper (String str) {
        if (str.isEmpty()) {
            return "";
        }

        if (str.charAt(0) == 'a') {
            return helper(str.substring(1));
        }
        return str.charAt(0) + helper(str.substring(1));
    }

    static String helperApple (String str) {
        if (str.isEmpty()) {
            return "";
        }

        if (str.startsWith("apple")) {
            // skips the first five letters, apple size = 5
            return helperApple(str.substring(5));
        }
        return str.charAt(0) + helperApple(str.substring(1));
    }
}
