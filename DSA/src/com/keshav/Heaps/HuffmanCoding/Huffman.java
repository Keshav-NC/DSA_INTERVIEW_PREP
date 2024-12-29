package com.keshav.Heaps.HuffmanCoding;

public class Huffman {
    public static void main(String[] args) {
        String data = "aaaaabbbbbbbbbccccccccccccdddddddddddddeeeeeeeeeeeeeeeefffffffffffffffffffffffffffffffffffffffffffff";
        HuffmanCoder hf = new HuffmanCoder(data);
        String encoded = hf.encoder(data);
        String decoded = hf.decoder(encoded);
        System.out.println(hf.res);
        System.out.println("Encoded Data : " + encoded);
        System.out.println("Decoded Data : " + decoded);
//        0 100 101 1100 1101 111
    }
}
