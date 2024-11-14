package app.saladservice;

import app.ingredient.Ingredient;

import java.util.ArrayList;

public class Salad {
    private String name;
    private ArrayList<Ingredient> salad;

    public Salad(String name, ArrayList<Ingredient> salad) {
        this.name = name;
        this.salad = new ArrayList<>(salad);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getSalad() {
        return this.salad;
    }
}
