package com.weihnachten.decorator.burger;

import java.util.Set;

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

    @Override
    public Set<Allergen> getAllergens() {
        Set<Allergen> allergens = tempBurger.getAllergens();
        allergens.add(Allergen.LAKTOSE);
        return allergens;
    }
}
