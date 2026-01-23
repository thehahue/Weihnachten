package com.weihnachten.decorator.burger;

public class Pickles extends BurgerDecorator {
    public Pickles(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public String getDescription() {
        return tempBurger.getDescription() + ", Gurkerl";
    }

    @Override
    public double getPrice() {
        return tempBurger.getPrice() + 0.40;
    }
}
