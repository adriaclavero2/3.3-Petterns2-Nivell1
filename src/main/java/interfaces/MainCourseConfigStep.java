package interfaces;

public interface MainCourseConfigStep {
    MainCourseConfigStep isVegan();
    MainCourseConfigStep isGlutenFree();
    MainCourseConfigStep withSupplement(String supplement);
    DessertOrCoffeeStep withDrink(String drink);
}