package com.keshav.Recursion.Questions;

public class Stream {
    public static void main(String[] args) {
        String str = "baappledfg";
        System.out.println(skip(str));
    }

    static String skip(String str) {
        return helperWithAnsArgs("", str);
//        return helperApple (str);
    }

    // Note : str.substring --> skips characters from start index till the mentioned index.

    static String helperWithAnsArgs(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return processed;
        }
        // skip if char 'a' found, don't add it to processed
        if (unprocessed.charAt(0) == 'a') {
           return helperWithAnsArgs(processed, unprocessed.substring(1));
        }

        // else add to processed
        return helperWithAnsArgs(processed + unprocessed.charAt(0), unprocessed.substring(1));
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
