

import builder.MenuBuilder;
import models.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class MenuBuilderTest {

    @Test
    void testExecutiveMenuComplete() {
        Menu menu = new MenuBuilder()
                .withEntrant("Amanida Mediterrània")
                .isVegan()
                .isGlutenFree()
                .withMainCourse("Filet de Vedella")
                .withSupplement("Guarnició extra")
                .withDrink("Vi Negre")
                .withDessert("Mousse de xocolata")
                .build();

        Assertions.assertNotNull(menu);
        Assertions.assertNotNull(menu.getEntrant());
        Assertions.assertEquals("Amanida Mediterrània", menu.getEntrant().getName());
        Assertions.assertTrue(menu.getEntrant().isVegan());
        Assertions.assertTrue(menu.getEntrant().isGlutenFree());

        Assertions.assertNotNull(menu.getMainCourse());
        Assertions.assertEquals("Filet de Vedella", menu.getMainCourse().getName());
        Assertions.assertEquals("Guarnició extra", menu.getMainCourse().getSupplement());

        Assertions.assertEquals("Vi Negre", menu.getDrink());
        Assertions.assertEquals("Mousse de xocolata", menu.getDessert());
        Assertions.assertNull(menu.getCoffee());
    }

    @Test
    void testKidsMenu() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Macarrons amb tomàquet")
                .withDrink("Suc de taronja")
                .withDessert("Gelat de Vainilla")
                .build();

        Assertions.assertNull(menu.getEntrant());
        Assertions.assertNotNull(menu.getMainCourse());
        Assertions.assertEquals("Macarrons amb tomàquet", menu.getMainCourse().getName());
        Assertions.assertEquals("Suc de taronja", menu.getDrink());
        Assertions.assertEquals("Gelat de Vainilla", menu.getDessert());
        Assertions.assertNull(menu.getCoffee());
    }

    @Test
    void testHalfMenuWithCoffee() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Risotto de bolets")
                .isVegan()
                .withDrink("Aigua")
                .withCoffee("Espresso")
                .build();

        Assertions.assertNull(menu.getEntrant());
        Assertions.assertNotNull(menu.getMainCourse());
        Assertions.assertTrue(menu.getMainCourse().isVegan());
        Assertions.assertEquals("Aigua", menu.getDrink());
        Assertions.assertEquals("Espresso", menu.getCoffee());
        Assertions.assertNull(menu.getDessert());
    }

    @Test
    void testMenuWithoutDessertOrCoffee() {
        Menu menu = new MenuBuilder()
                .withEntrant("Croquetes")
                .withMainCourse("Paella")
                .isGlutenFree()
                .withDrink("Cervesa")
                .build();

        Assertions.assertNotNull(menu.getEntrant());
        Assertions.assertEquals("Croquetes", menu.getEntrant().getName());
        Assertions.assertEquals("Paella", menu.getMainCourse().getName());
        Assertions.assertTrue(menu.getMainCourse().isGlutenFree());
        Assertions.assertNull(menu.getDessert());
        Assertions.assertNull(menu.getCoffee());
    }

    @Test
    void testMainCourseWithMultipleConfigurations() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Hamburguesa vegetal")
                .isVegan()
                .isGlutenFree()
                .withSupplement("Patates fregides")
                .withDrink("Refresc")
                .withDessert("Fruita")
                .build();

        Assertions.assertTrue(menu.getMainCourse().isVegan());
        Assertions.assertTrue(menu.getMainCourse().isGlutenFree());
        Assertions.assertEquals("Patates fregides", menu.getMainCourse().getSupplement());
    }
}