package com.keshav.OOPS.Properties.Inheritance;

public class Inheritance {
    public static void main(String[] args) {
//        Box box1 = new Box(4);
//        System.out.println(box1.l + " " + box1.h + " " + box1.w);

//        Box box2 = new Box(2, 3, 4);
//        System.out.println((box2.l + " " + box2.h + " " + box2.w));
//
//        Box box3 = new Box(box2);
//        System.out.println((box3.l + " " + box3.h + " " + box3.w));

        BoxWeight boxWeight = new BoxWeight(1, 2, 3, 4);
        System.out.println((boxWeight.l + " " + boxWeight.h + " " + boxWeight.w + " " + boxWeight.weight));

    }
}
