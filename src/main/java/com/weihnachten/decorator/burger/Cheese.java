package com.weihnachten.decorator.burger;

public class Cheese extends BurgerDecorator {
    public Cheese(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public String getDescription() {
        return tempBurger.getDescription() + ", Käse";
    }

    @Override
    public double getPrice() {
        return tempBurger.getPrice() + 0.80;
    }
}
