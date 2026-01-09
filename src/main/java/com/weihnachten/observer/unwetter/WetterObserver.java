package com.weihnachten.observer.unwetter;

public interface WetterObserver {
    void update(Unwetterstatus status);
}
