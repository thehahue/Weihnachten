package com.weihnachten.decorator.burger;

public class Bacon extends BurgerDecorator {
    public Bacon(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public String getDescription() {
        return tempBurger.getDescription() + ", knusper Bacon";
    }

    @Override
    public double getPrice() {
        return tempBurger.getPrice() + 1.20;
    }

    @Override
    public java.util.List<String> getImageLayers() {
        java.util.List<String> layers = tempBurger.getImageLayers();
        layers.add(layers.size() - 1, "bacon");
        return layers;
    }
}
