package main;

import builder.MenuBuilder;

public class Main {
    public static void main(String[] args) {
        String menu = new MenuBuilder()
                .withEntrant("Salad")
                .isVegan()
                .withMainCourse("Pasta")
                .withSuplement("Parmesan")
                .isMainGlutenFree()
                .withDrink("Pepsi")
                .withDessert("Cheese cake")
                .finish()
                .build();

        System.out.println(menu);
    }
}
