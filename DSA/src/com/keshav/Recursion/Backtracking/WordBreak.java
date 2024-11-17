package com.keshav.Recursion.Backtracking;

import javax.swing.text.Style;
import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String word = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        HashMap<Character, String> map = new HashMap<>();
        System.out.println(wordBreak(word, new HashSet<>(wordDict)));
    }

    private static List<String> wordBreak(String word, HashSet<String> dict) {
        List<String> ans = new ArrayList<>();
        helper(0, word, dict, new ArrayList<>(), ans);
        return ans;
    }

    private static void helper(int start, String s, HashSet<String> dictSet, List<String> sub, List<String> ans) {
        if (start == s.length()) {
            StringBuilder sentence = new StringBuilder();
            for (int j = 0; j < sub.size(); ++j) {
                sentence.append(sub.get(j));
                if (j != sub.size() - 1) {
                    sentence.append(" ");
                }
            }
            ans.add(sentence.toString());
            return;
        }
        for (int i = start; i < s.length(); ++i) {
            if (dictSet.contains(s.substring(start, i+1))) {
                sub.add(s.substring(start, i+1));
                helper(i + 1, s, dictSet, sub, ans);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
