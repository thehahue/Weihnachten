package com.weihnachten.decorator.burger;

public class MeatPatty extends BurgerDecorator {
    public MeatPatty(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public String getDescription() {
        return tempBurger.getDescription() + ", Rindfleisch Patty";
    }

    @Override
    public double getPrice() {
        return tempBurger.getPrice() + 2.50;
    }
}
