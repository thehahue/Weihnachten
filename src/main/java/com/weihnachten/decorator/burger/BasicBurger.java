package com.weihnachten.decorator.burger;

import java.util.HashSet;
import java.util.Set;

public class BasicBurger implements Burger {
    @Override
    public String getDescription() {
        return "Basis Burger (Brötchen)";
    }

    @Override
    public double getPrice() {
        return 3.50;
    }

    @Override
    public Set<String> getAllergens() {
        Set<String> allergens = new HashSet<>();
        allergens.add("Gluten");
        return allergens;
    }
}
