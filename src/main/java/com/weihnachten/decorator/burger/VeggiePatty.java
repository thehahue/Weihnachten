package com.weihnachten.decorator.burger;

public class VeggiePatty extends BurgerDecorator {
    public VeggiePatty(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public String getDescription() {
        return tempBurger.getDescription() + ", Veggie Patty";
    }

    @Override
    public double getPrice() {
        return tempBurger.getPrice() + 2.20;
    }
}
