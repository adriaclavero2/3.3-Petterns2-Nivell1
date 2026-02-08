package builder;

import interfaces.DessertStep;
import interfaces.BuildStep;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MenuBuilderTest {

    @Test
    void testMainCourseIsRequiredBeforeDrink() {
        MenuBuilder builder = new MenuBuilder();

        IllegalStateException ex = Assertions.assertThrows(
                IllegalStateException.class,
                () -> builder.withDrink("Coke")
        );

        Assertions.assertEquals(
                "You must add the main course before adding a drink.",
                ex.getMessage()
        );
    }

    @Test
    void testMainCourseIsRequiredBeforeDessert() {
        MenuBuilder builder = new MenuBuilder();

        IllegalStateException ex = Assertions.assertThrows(
                IllegalStateException.class,
                () -> builder.withDessert("Cake")
        );

        Assertions.assertEquals(
                "You must add the main course before adding dessert.",
                ex.getMessage()
        );
    }

    @Test
    void testMainCourseIsRequiredBeforeCoffee() {
        MenuBuilder builder = new MenuBuilder();

        IllegalStateException ex = Assertions.assertThrows(
                IllegalStateException.class,
                () -> builder.withCoffee("Latte")
        );

        Assertions.assertEquals(
                "You must add the main course before adding coffee.",
                ex.getMessage()
        );
    }

    @Test
    void testCannotAddEntrantAfterMainCourse() {
        MenuBuilder builder = new MenuBuilder()
                .withMainCourse("Pasta");

        IllegalStateException ex = Assertions.assertThrows(
                IllegalStateException.class,
                () -> builder.withEntrant("Salad")
        );

        Assertions.assertEquals(
                "You cannot add an appetizer after the main course.",
                ex.getMessage()
        );
    }

    @Test
    void testDessertStepTypeIsReturned() {
        DessertStep step = new MenuBuilder()
                .withMainCourse("Pasta")
                .withDessert("Cake");

        Assertions.assertNotNull(step);
    }

    @Test
    void testCoffeeStepTypeIsReturned() {
        BuildStep step = new MenuBuilder()
                .withMainCourse("Pasta")
                .withCoffee("Latte")
                .finish();

        Assertions.assertNotNull(step);
    }

    @Test
    void testBuildProducesValidJson() {
        String json = new MenuBuilder()
                .withEntrant("Salad")
                .withMainCourse("Pasta")
                .withDrink("Water")
                .withDessert("Cake")
                .finish()
                .build();

        Assertions.assertTrue(json.contains("Salad"));
        Assertions.assertTrue(json.contains("Pasta"));
        Assertions.assertTrue(json.contains("Water"));
        Assertions.assertTrue(json.contains("Cake"));
    }
}