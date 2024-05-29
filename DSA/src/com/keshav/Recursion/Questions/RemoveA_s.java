package com.keshav.Recursion.Questions;

public class RemoveA_s {
    public static void main(String[] args) {
        String str = "baccad";
        System.out.println(helper(str));
    }

    static String removeA_s (String str) {
        return helperWithAnsArgs("", str);
    }

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
}
