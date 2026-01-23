package com.weihnachten.decorator.burger;

public class BasicBurger implements Burger {
    @Override
    public String getDescription() {
        return "Basis Burger (Brötchen)";
    }

    @Override
    public double getPrice() {
        return 3.50;
    }
}
