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
    public Set<Allergen> getAllergens() {
        Set<Allergen> allergens = tempBurger.getAllergens();
        allergens.add(Allergen.EI);
        allergens.add(Allergen.SENF);
        return allergens;
    }

    @Override
    public java.util.List<String> getImageLayers() {
        java.util.List<String> layers = tempBurger.getImageLayers();
        layers.add(layers.size() - 1, "mayo");
        return layers;
    }
}
