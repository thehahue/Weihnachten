package com.weihnachten.observer;

import java.util.ArrayList;
import java.util.List;

public class Lieferung implements Subject {
    private List<Observer> observers;
    private GeschenkStatus status;

    public Lieferung() {
        this.observers = new ArrayList<>();
        this.status = GeschenkStatus.IN_ARBEIT;
    }

    public void setStatus(GeschenkStatus status) {
        this.status = status;
        System.out.println("Lieferung: Status geändert auf " + status);
        notifyObservers();
    }

    public GeschenkStatus getStatus() {
        return status;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}
