package com.weihnachten.observer.auktion;

public interface Observer {
    void update(AuktionStatus status, Auktion auktion);
}
