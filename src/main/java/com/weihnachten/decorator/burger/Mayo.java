package com.weihnachten.decorator.burger;

public class Mayo extends BurgerDecorator {
    public Mayo(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public String getDescription() {
        return tempBurger.getDescription() + ", Mayo";
    }

    @Override
    public double getPrice() {
        return tempBurger.getPrice() + 0.30;
    }
}
