package com.weihnachten.strategy;

public class SchnellsteRoute implements RoutenStrategie {
    @Override
    public void berechneRoute(String ziel) {
        System.out.println("Berechne schnellste Route nach " + ziel + ": Über die Autobahn der Winde.");
    }
}
