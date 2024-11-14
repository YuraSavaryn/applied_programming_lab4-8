package app.techservice;

import app.ingredient.Ingredient;
import app.saladservice.Salad;

import java.util.ArrayList;

public class TechService {
    private ArrayList<Salad> fridge = new ArrayList<>();

    public void addSalad(Salad salad) {
        this.fridge.add(salad);
    }

    public void openFridge() {
        if (fridge.isEmpty()) {
            System.out.println("Salad is empty.");
        } else {
            System.out.println("Current salads in fridge:");
            int count = 1;
            for (Salad salad : fridge) {
                System.out.println(count + ". " + salad.getName());
                for (Ingredient ingredient : salad.getSalad()) {
                    System.out.println("\t- " + ingredient.getName() + " (" + ingredient.getCalories() + " kcal, " +
                            ingredient.getWeight() + " grams)");
                }
                count++;
            }
        }
    }

    public ArrayList<Salad> getSalads() {
        return fridge;
    }
}
