package models;

public class Menu {
    private final Dish entrant;
    private final Dish mainCourse;
    private final String drink;
    private final String dessert;
    private final String coffee;

    public Menu(Dish entrant, Dish mainCourse, String drink, String dessert, String coffee) {
        this.entrant = entrant;
        this.mainCourse = mainCourse;
        this.drink = drink;
        this.dessert = dessert;
        this.coffee = coffee;
    }

    public Dish getEntrant() {
        return entrant;
    }

    public Dish getMainCourse() {
        return mainCourse;
    }

    public String getDrink() {
        return drink;
    }

    public String getDessert() {
        return dessert;
    }

    public String getCoffee() {
        return coffee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Menu:\n");
        if (entrant != null) {
            sb.append(" - Entrant: ").append(entrant).append("\n");
        }
        sb.append(" - Plat Principal: ").append(mainCourse).append("\n");
        if (drink != null) {
            sb.append(" - Beguda: ").append(drink).append("\n");
        }
        if (dessert != null) {
            sb.append(" - Postres: ").append(dessert).append("\n");
        }
        if (coffee != null) {
            sb.append(" - Cafè: ").append(coffee).append("\n");
        }
        return sb.toString();
    }
}