package com.weihnachten.decorator.burger;

public abstract class BurgerDecorator implements Burger {
    protected Burger tempBurger;

    public BurgerDecorator(Burger newBurger) {
        tempBurger = newBurger;
    }

    @Override
    public String getDescription() {
        return tempBurger.getDescription();
    }

    @Override
    public double getPrice() {
        return tempBurger.getPrice();
    }
}
