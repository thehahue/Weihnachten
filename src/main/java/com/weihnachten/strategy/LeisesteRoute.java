package com.weihnachten.strategy;

public class LeisesteRoute implements RoutenStrategie {
    @Override
    public void berechneRoute(String ziel) {
        System.out.println("Berechne leiseste Route nach " + ziel + ": Gleite über die Wolken.");
    }
}
