package models;

public class Dish {
    private final String name;
    private boolean vegan;
    private boolean glutenFree;
    private String supplement;

    public Dish(String name) {
        this.name = name;
        this.vegan = false;
        this.glutenFree = false;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public String getName() {
        return name;
    }

    public boolean isVegan() {
        return vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public String getSupplement() {
        return supplement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        if (vegan) sb.append(" (Vegan)");
        if (glutenFree) sb.append(" (Gluten Free)");
        if (supplement != null) sb.append(", Suplement: ").append(supplement);
        return sb.toString();
    }
}