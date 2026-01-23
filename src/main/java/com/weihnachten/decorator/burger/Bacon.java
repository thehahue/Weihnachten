package com.weihnachten.decorator.burger;

public class Bacon extends BurgerDecorator {
    public Bacon(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public String getDescription() {
        return tempBurger.getDescription() + ", knusper Bacon";
    }

    @Override
    public double getPrice() {
        return tempBurger.getPrice() + 1.20;
    }
}
