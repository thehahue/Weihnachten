package com.weihnachten.observer.unwetter;

public interface WetterSubject {
    void registerObserver(WetterObserver o);
    void removeObserver(WetterObserver o);
    void notifyObservers();
}
