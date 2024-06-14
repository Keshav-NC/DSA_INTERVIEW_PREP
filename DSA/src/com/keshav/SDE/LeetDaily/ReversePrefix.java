package com.keshav.SDE.LeetDaily;

public class ReversePrefix {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix (word, ch));
//        reversePrefix (word, ch);
    }

    private static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        String str = word.substring(0, index+1);
        String ans = "";
        for (char c : str.toCharArray()) {
            ans = c + ans;
        }

        return ans + word.substring(index+1);
    }
}
