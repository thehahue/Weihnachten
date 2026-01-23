package com.weihnachten.decorator.burger;

import java.util.Set;

public interface Burger {
    String getDescription();

    double getPrice();

    Set<Allergen> getAllergens();

    java.util.List<String> getImageLayers();
}
