package com.weihnachten.strategy.demo;

public interface DiscountStrategy {
    double applyDiscount(double price);

    String getName();

    String getDescription();
}
