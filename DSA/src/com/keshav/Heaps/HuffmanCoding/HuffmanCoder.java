package com.keshav.Heaps.HuffmanCoding;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoder {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;
    ArrayList<String> res;
    class Node implements Comparable<Node> {
        Character data;
        int cost; // freq
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            left = right = null;
        }
        @Override
        public int compareTo(Node that) {
            return this.cost - that.cost;
        }

        @Override
        public String toString() {
            return "Data : " + this.data + ", Cost : " + this.cost + "\n";
        }
    }

    // 1) Pass the string / data
    public HuffmanCoder(String data) {
        // 2) Make freq map
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : data.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // 3) For every key int freq map, create a node and insert that node in minHeap
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            Character ch = entry.getKey();
            Integer cost = entry.getValue();
            minHeap.offer(new Node(ch, cost));
        }
        System.out.println(minHeap);
        // 4) Remove 2 elements for the heap and combine
        while (minHeap.size() != 1) {
            Node first = minHeap.poll();
            Node second = minHeap.poll();

            Node newNode = new Node('/', first.cost + second.cost);
            // connect links
            newNode.left = first;
            newNode.right = second;
            // insert the combined node into minHeap
            minHeap.offer(newNode);
        }
        // final tree --> root
        Node root = minHeap.poll();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();
        res = new ArrayList<>();
        this.initEncoderDecoder(root, new StringBuilder(), res);
    }

    // preorder
    private void initEncoderDecoder(Node root, StringBuilder pathBits, ArrayList<String> res) {
        if (root == null) {
            return;
        }
        // ans -> leaf node
        if (root.left == null && root.right == null) {
            res.add(pathBits.toString());
            this.encoder.put(root.data, pathBits.toString());
            this.decoder.put(pathBits.toString(), root.data);
        }
        // left - '0'
        initEncoderDecoder(root.left, pathBits.append('0'), res);
        pathBits.deleteCharAt(pathBits.length() - 1);
        // right - '1'
        initEncoderDecoder(root.right, pathBits.append('1'), res);
        pathBits.deleteCharAt(pathBits.length() - 1);
    }

    public String encoder(String data) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : data.toCharArray()) {
            if (encoder.containsKey(ch)) {
                encoded.append(encoder.get(ch));
            }
        }
        return encoded.toString();
    }
    public String decoder(String encoded) {
        StringBuilder decoded = new StringBuilder();
        String key = "";
        for (char ch : encoded.toCharArray()) {
            key += ch;
            if (decoder.containsKey(key)) {
                decoded.append(decoder.get(key));
                key = "";
            }
        }
        return decoded.toString();
    }
}
