package main;

import builder.MenuBuilder;
import models.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("EXEMPLES D'ÚS DEL MENU BUILDER");
        System.out.println("=".repeat(60));


        System.out.println("\n1. MENÚ EXECUTIU:");
        Menu executiveMenu = new MenuBuilder()
                .withEntrant("Amanida Mediterrània")
                .isVegan()
                .isGlutenFree()
                .withMainCourse("Filet de Vedella")
                .withSupplement("Guarnició extra")
                .withDrink("Vi Negre")
                .withDessert("Mousse de xocolata")
                .build();
        System.out.println(executiveMenu);

        System.out.println("\n2. MENÚ INFANTIL:");
        Menu kidsMenu = new MenuBuilder()
                .withMainCourse("Macarrons amb tomàquet")
                .withDrink("Suc de taronja")
                .withDessert("Gelat de Vainilla")
                .build();
        System.out.println(kidsMenu);

        System.out.println("\n3. MIG MENÚ AMB CAFÈ:");
        Menu halfMenu = new MenuBuilder()
                .withMainCourse("Risotto de bolets")
                .isVegan()
                .withDrink("Aigua")
                .withCoffee("Espresso")
                .build();
        System.out.println(halfMenu);
    }
}