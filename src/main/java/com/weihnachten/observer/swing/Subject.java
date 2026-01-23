package com.weihnachten.observer.swing;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    protected void notifyObservers(Auction auction) {
        for (Observer o : observers) {
            o.update(auction);
        }
    }
}
