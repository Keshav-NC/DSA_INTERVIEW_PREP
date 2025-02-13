package com.keshav.OOPS.Properties.Inheritance;

public class BoxWeight extends Box{
    double weight;

    public BoxWeight() {
        this.weight = -1;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        // used to initialize values present in parent class
        super(l, h, w); // calls the parent class constructor (depends on parameters)

        this.weight = weight;
    }
}
