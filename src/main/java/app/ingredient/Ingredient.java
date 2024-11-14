package app.ingredient;

public abstract class Ingredient {
    protected String name;
    protected int calories;
    protected int weight;

    public Ingredient(String name, int calories, int weight) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getWeight() {
        return weight;
    }
}