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
    public Set<Allergen> getAllergens() {
        Set<Allergen> allergens = new HashSet<>();
        allergens.add(Allergen.GLUTEN);
        allergens.add(Allergen.SESAM);
        return allergens;
    }
}
