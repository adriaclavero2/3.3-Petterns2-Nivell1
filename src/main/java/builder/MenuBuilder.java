package builder;

import interfaces.*;
import models.Dish;
import models.Menu;

public class MenuBuilder implements EntrantStep {

    private Dish entrant;
    private Dish mainCourse;
    private String drink;
    private String dessert;
    private String coffee;


    @Override
    public EntrantConfigStep withEntrant(String name) {
        this.entrant = new Dish(name);
        return new EntrantConfigurator(this);
    }

    @Override
    public MainCourseConfigStep withMainCourse(String name) {
        this.mainCourse = new Dish(name);
        return new MainCourseConfigurator(this);
    }

    private static class EntrantConfigurator implements EntrantConfigStep {
        private final MenuBuilder builder;

        EntrantConfigurator(MenuBuilder builder) {
            this.builder = builder;
        }

        @Override
        public EntrantConfigStep isVegan() {
            builder.entrant.setVegan(true);
            return this;
        }

        @Override
        public EntrantConfigStep isGlutenFree() {
            builder.entrant.setGlutenFree(true);
            return this;
        }

        @Override
        public MainCourseConfigStep withMainCourse(String name) {
            builder.mainCourse = new Dish(name);
            return new MainCourseConfigurator(builder);
        }
    }

    private static class MainCourseConfigurator implements MainCourseConfigStep {
        private final MenuBuilder builder;

        MainCourseConfigurator(MenuBuilder builder) {
            this.builder = builder;
        }

        @Override
        public MainCourseConfigStep isVegan() {
            builder.mainCourse.setVegan(true);
            return this;
        }

        @Override
        public MainCourseConfigStep isGlutenFree() {
            builder.mainCourse.setGlutenFree(true);
            return this;
        }

        @Override
        public MainCourseConfigStep withSupplement(String supplement) {
            builder.mainCourse.setSupplement(supplement);
            return this;
        }

        @Override
        public DessertOrCoffeeStep withDrink(String drink) {
            builder.drink = drink;
            return new DessertOrCoffeeConfigurator(builder);
        }
    }

    private static class DessertOrCoffeeConfigurator implements DessertOrCoffeeStep, BuildStep {
        private final MenuBuilder builder;

        DessertOrCoffeeConfigurator(MenuBuilder builder) {
            this.builder = builder;
        }

        @Override
        public BuildStep withDessert(String name) {
            builder.dessert = name;
            return this;
        }

        @Override
        public BuildStep withCoffee(String name) {
            builder.coffee = name;
            return this;
        }

        @Override
        public Menu build() {
            return new Menu(builder.entrant, builder.mainCourse, builder.drink, builder.dessert, builder.coffee);
        }
    }
}