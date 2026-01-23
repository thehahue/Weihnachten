package com.weihnachten.decorator.burger;

public class Pickles extends BurgerDecorator {
    public Pickles(Burger newBurger) {
        super(newBurger);
    }

    @Override
    public String getDescription() {
        return tempBurger.getDescription() + ", Gurkerl";
    }

    @Override
    public double getPrice() {
        return tempBurger.getPrice() + 0.40;
    }

    @Override
    public java.util.List<String> getImageLayers() {
        java.util.List<String> layers = tempBurger.getImageLayers();
        layers.add(layers.size() - 1, "pickles");
        return layers;
    }
}
