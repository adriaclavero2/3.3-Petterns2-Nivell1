package interfaces;

import models.Menu;

public interface DessertOrCoffeeStep {
    BuildStep withDessert(String name);
    BuildStep withCoffee(String name);
    Menu build();
}