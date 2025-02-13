package com.keshav.OOPS.Properties.Interfaces;

public class CDPlayer implements Media{
    @Override
    public void play() {
        System.out.println("I play music");
    }

    @Override
    public void pause() {
        System.out.println("I pause music");

    }

    @Override
    public void stop() {
        System.out.println("I stop music");

    }
}
