package com.weihnachten.decorator.burger;

import java.util.Set;

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

    @Override
    public Set<Allergen> getAllergens() {
        return tempBurger.getAllergens();
    }
}
