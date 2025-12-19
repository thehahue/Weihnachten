package com.weihnachten.strategy;

public class SturmSicherRoute implements RoutenStrategie {
    @Override
    public void berechneRoute(String ziel) {
        System.out.println("Berechne sturm-sichere Route nach " + ziel + ": Umgehe das Tiefdruckgebiet.");
    }
}
