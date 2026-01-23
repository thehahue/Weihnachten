package com.weihnachten.decorator.burger;

import java.util.Set;

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

    @Override
    public Set<String> getAllergens() {
        Set<String> allergens = tempBurger.getAllergens();
        allergens.add("Ei");
        allergens.add("Senf");
        return allergens;
    }
}
