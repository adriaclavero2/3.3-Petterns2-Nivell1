package builder;

import interfaces.BuildStep;
import interfaces.CoffeeStep;
import interfaces.DessertStep;
import org.json.JSONObject;

public class MenuBuilder implements DessertStep, CoffeeStep, BuildStep {

    private final JSONObject menu;

    public MenuBuilder() {
        this.menu = new JSONObject();
    }

    @Override
    public BuildStep finish() {
        return this;
    }

    public MenuBuilder withMainCourse(String name) {
        JSONObject main = new JSONObject();
        main.put("name", name);
        menu.put("mainCourse", main);
        return this;
    }

    public MenuBuilder withSuplement(String suplement) {
        if (!menu.has("mainCourse")) {
            throw new IllegalStateException("You must add the main course before adding a suplement.");
        }

        JSONObject main = menu.getJSONObject("mainCourse");
        main.put("suplement", suplement);
        return this;
    }

    public MenuBuilder isMainVegan() {
        if (!menu.has("mainCourse")) {
            throw new IllegalStateException("You must add the main course before marking it as vegan.");
        }

        JSONObject main = menu.getJSONObject("mainCourse");
        main.put("vegan", true);
        return this;
    }

    public MenuBuilder isMainGlutenFree() {
        if (!menu.has("mainCourse")) {
            throw new IllegalStateException("You must add the main course before marking it as gluten-free.");
        }

        JSONObject main = menu.getJSONObject("mainCourse");
        main.put("glutenFree", true);
        return this;
    }

    public MenuBuilder withDrink(String drink) {
        if (!menu.has("mainCourse")) {
            throw new IllegalStateException("You must add the main course before adding a drink.");
        }

        menu.put("drink", drink);
        return this;
    }

    public MenuBuilder withEntrant(String name) {
        if (menu.has("mainCourse")) {
            throw new IllegalStateException("You cannot add an appetizer after the main course.");
        }

        JSONObject entrant = new JSONObject();
        entrant.put("name", name);
        menu.put("entrant", entrant);
        return this;
    }

    public MenuBuilder isVegan() {
        if (!menu.has("entrant")) {
            throw new IllegalStateException("You must add an appetizer before marking it as vegan.");
        }

        JSONObject entrant = menu.getJSONObject("entrant");
        entrant.put("vegan", true);
        return this;
    }

    public MenuBuilder isGlutenFree() {
        if (!menu.has("entrant")) {
            throw new IllegalStateException("You must add an appetizer before marking it as gluten-free.");
        }

        JSONObject entrant = menu.getJSONObject("entrant");
        entrant.put("glutenFree", true);
        return this;
    }

    public DessertStep withDessert(String name) {
        if (!menu.has("mainCourse")) {
            throw new IllegalStateException("You must add the main course before adding dessert.");
        }

        JSONObject dessert = new JSONObject();
        dessert.put("name", name);
        menu.put("dessert", dessert);
        return this;
    }

    public CoffeeStep withCoffee(String name) {
        if (!menu.has("mainCourse")) {
            throw new IllegalStateException("You must add the main course before adding coffee.");
        }

        JSONObject coffee = new JSONObject();
        coffee.put("name", name);
        menu.put("coffee", coffee);
        return this;
    }

    @Override
    public String build() {
        return menu.toString(2);
    }
}