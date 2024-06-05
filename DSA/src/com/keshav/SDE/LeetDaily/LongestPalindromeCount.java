package com.keshav.SDE.LeetDaily;

import java.util.HashMap;
import java.util.HashSet;

public class LongestPalindromeCount {
    public static void main(String[] args) {
//        System.out.println(longPalindromeMap("abccccdd"));
//        System.out.println(longPalindromeSet("abccccdd"));
        System.out.println(longPalArr("abccccdd"));
    }

    static int longPalindromeMap(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int res = 0;
        int oddCount = 0;

        for (char ch : str.toCharArray()) {
            // here if the character was already present then ch + 1, else if not 0 + 1
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            int curFreq = freq.get(ch);
            if (curFreq % 2 == 0) {
                // if even, then add pairs in the res
                res += 2;
                // decrement the oddCount by 1
                oddCount--;
            } else {
                oddCount++;
            }
        }
        if (oddCount > 0) {
            res += 1;
        }
        return res;
    }

    static int longPalindromeSet (String str) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;

        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                res += 2;
                set.remove(ch);
            }
        }
        if (!set.isEmpty()) {
            res += 1;
        }
        return res;
    }

    static int longPalArr (String s) {
        // Initialize an array to store the frequency of the characters
        // The size of the array is chosen based on the ASCII value of the characters
        // 'A' - 'Z' --> ASCII of 65 - 90, whereas 'a' - 'z' --> ASCII of 97 - 122
        // size of array = 122 - 60 = 57 (0 to 57) --> 58
        int[] arr = new int[58];

        // Initialize total counter for total characters forming palindrome and count of odd characters
        int count = 0;
        int odd = 0;

        // Iterate through each character in the input string

        for (char ch : s.toCharArray()) {
            // Increment the count of the corresponding character in the arr
            arr[ch - 'A']++;
        }

        // Iterate through arr to check the frequencies of character
        for (int ch : arr) {
            // If the character freq is even and not zero, it can from the palindrome
            if (ch % 2 ==0 && ch != 0) {
                // Add the even count to the total character forming the palindrome
                count += ch;
            // If character count is odd and not one, can form a palindrome
            } else if (ch % 2 == 1 && ch != 1) {
                // Add count less than 1 of the odd freq to the total count of the characters
                count += ch - 1;
                // Set the flag 'odd' to indicate the presence of an odd character.
                odd = 1;
            // If the character frequency is one, it is an odd character.
            }else if(ch == 1) {
                // Set the flag 'odd' to indicate the presence of an odd character.
                odd = 1;
            }
        }
        // Return the total count of characters forming palindromes, adding an odd character if present.
        return count + odd;
    }
}
