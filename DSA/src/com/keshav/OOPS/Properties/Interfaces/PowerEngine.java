package com.keshav.OOPS.Properties.Interfaces;

public class PowerEngine implements Engine{
    @Override
    public void start() {
        System.out.println("I start PowerEngine");
    }

    @Override
    public void stop() {
        System.out.println("I stop PowerEngine");
    }

    @Override
    public void accelerate() {
        System.out.println("I accelerate PowerEngine");
    }
}
