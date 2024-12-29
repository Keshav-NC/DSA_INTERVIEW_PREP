package com.keshav.Graphs.Questions;

import javax.swing.plaf.LabelUI;
import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation(startGene, endGene, bank));
    }

    private static int minMutation(String startGene, String endGene, String[] bank) {
        int[] ex = new int[10];
        Set<String> seen = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return level;
                }
                List<String> neighbours = getNeighbours(gene, seen);
                for (String neighbour : neighbours) {
                    seen.remove(neighbour);
                    queue.offer(neighbour);
                }
            }
            ++level;
        }
        return -1;
    }

    private static List<String> getNeighbours(String gene, Set<String> seen) {
        List<String> neighbours = new ArrayList<>();
        char[] genes = {'A', 'C', 'G', 'T'};
        for (int i = 0; i < gene.length(); i++) {
            for (char ch : genes) {
                String newGene = gene.substring(0, i) + ch + gene.substring(i + 1);
                if (seen.contains(newGene)) {
                    neighbours.add(newGene);
                }
            }
        }
        return neighbours;
    }
}
