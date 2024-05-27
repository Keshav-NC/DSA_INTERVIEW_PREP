package com.keshav.Strings;

public class Comparisons {
    public static void main(String[] args) {
        // == --> comparator checks if the reference variable are pointing to the same to the object in the heap --> returns true or else returns false.
        // NOTE: use this initialisation to utilize string pool in order to maintain security
        String a = "Keshav";
        String b = "Keshav";
        System.out.println(a == b); // it returns true coz both ref var pointing to same object in the heap within the same string pool.

        // How to create different objects of same value --> done by explicitly
        // NOTE: but this is not the right way to create objects, we have to utilize string pool,so we use the above initialisation
        String name1 = new String("Keshav");
        String name2 = new String("Keshav");
        System.out.println(name1 == name2); // it returns false coz both ref var pointing to diff objects outside the string pool but in heap which is done by explicitly
        // if order to check if the objects are same --> use .equals() method.
        System.out.println(name1.equals(name2)); // returns true irrespective of what the ref var pointing to, its just checks if the objects are same
    }
}
