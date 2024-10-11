package com.keshav.Heaps.Questions;

import java.util.*;

class FrequentWords implements Comparable<FrequentWords> {
    String word;
    int freq;

    public FrequentWords (String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    @Override
    public int compareTo(FrequentWords that) {
        if (this.freq == that.freq) {
            return this.word.compareTo(that.word);
        }
        return that.freq - this.freq; // desc --> largest to smallest
    }

    @Override
    public String toString() {
        return "\nWord : " + this.word + ", Freq : " + this.freq;
    }
}

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        System.out.println(frequentWords(words, k));
    }

    private static List<String> frequentWords(String[] words, int k) {
        PriorityQueue<FrequentWords> maxHeap = new PriorityQueue<>();
        HashMap<String, Integer> freq = new HashMap<>();

        // find freq of words
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            FrequentWords obj = new FrequentWords(entry.getKey(), entry.getValue());
            maxHeap.offer(obj);
        }
        System.out.println(maxHeap);
        System.out.println();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            ans.add(maxHeap.poll().word);
        }

        return ans;
    }
}
