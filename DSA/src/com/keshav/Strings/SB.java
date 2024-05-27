package com.keshav.Strings;

public class SB {
    public static void main(String[] args) {
        String series = "";
//        for (char i=0;i<26;i++) {
//            // Performance degraded coz for every iteration its creating an new object and the previous
//            // object will become garbage value coz now the ref var is pointing to the newly created object.
//            // this happens because String is IMMUTABLE.
//            series += (char) ('a'+i);
//        }
        // In order to improve performance use StringBuilder
        // which is MUTABLE --> it doesn't create new object for every iteration, its just modifies the original object.
        StringBuilder builder = new StringBuilder();
        for (char i=0;i<26;i++) {
            builder.append((char) ('a' + i));
        }

        System.out.println(builder);
    }
}
