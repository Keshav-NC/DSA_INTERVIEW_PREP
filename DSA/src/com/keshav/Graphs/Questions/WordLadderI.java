package com.keshav.Graphs.Questions;

import java.util.*;

public class WordLadderI {
    public static void main(String[] args) {
        String startWord = "hit";
        String targetWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(startWord, targetWord, wordList));
    }

    private static int ladderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> seen = new HashSet<>(wordList);
        if (!seen.contains(targetWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(startWord);
        if (seen.contains(startWord)) {
            // mark as visited
            seen.remove(startWord);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(targetWord)) {
                    return level + 1;
                }
                List<String> neighbours = getNeighbours(word, seen);
                for (String neighbour : neighbours) {
                    seen.remove(neighbour);
                    queue.offer(neighbour);
                }
            }
            ++level;
        }
        return 0;
    }

    private static List<String> getNeighbours(String word, Set<String> seen) {
        List<String> neighbours = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String newWord = word.substring(0, i) + ch + word.substring(i + 1);
                if (seen.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }
}
