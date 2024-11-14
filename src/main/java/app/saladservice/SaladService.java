package app.saladservice;

import app.ingredient.Ingredient;
import app.techservice.TechService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SaladService {
    private ArrayList<Ingredient> salad = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        salad.add(ingredient);
        System.out.println(ingredient.getName() + " added to the salad.");
    }

    public void removeIngredient(String name) {
        Ingredient ingredient = this.getIngredient(name);
        if (ingredient != null) {
            salad.remove(ingredient);
            System.out.println("Removing an ingredient: " + ingredient.getName());
        }
        else {
            System.out.println("Ingredient doesn't exists in salad!");
        }
    }

    public void calculateCalories() {
        int totalCalories = salad.stream().mapToInt(Ingredient::getCalories).sum();
        System.out.println("Total calories of the salad: " + totalCalories + " kcal");
    }

    public void showSalad() {
        if (salad.isEmpty()) {
            System.out.println("Salad is empty.");
        } else {
            System.out.println("Current salad ingredients:");
            for (Ingredient ingredient : salad) {
                System.out.println("- " + ingredient.getName() + " (" + ingredient.getCalories() + " kcal, " +
                        ingredient.getWeight() + " grams)");
            }
        }
    }

    public void sortIngredients(int parameter) {
        if (parameter == 1) {
            Collections.sort(salad, new SortByCalories());
            System.out.println("Ingredients sorted by calories");
        }
        else {
            Collections.sort(salad, new SortByWeight());
            System.out.println("Ingredients sorted by weight");
        }
    }

    public void makeSalad(String name, TechService techService) {
        if (salad.isEmpty()) {
            System.out.println("\nSalad is empty. You should add some ingredients");
        } else {
            System.out.println("\nA new salad has been created - " + name);
            System.out.println("Salad ingredients:");
            int weight = 0;
            for (Ingredient ingredient : salad) {
                System.out.println("- " + ingredient.getName() + " (" + ingredient.getCalories() + " kcal, " +
                        ingredient.getWeight() + " grams)");
                weight += ingredient.getWeight();
            }
            System.out.println("Total weight of salad: " + weight + " grams");
            techService.addSalad(new Salad(name, salad));
            salad.clear();
        }
    }

    public ArrayList<Ingredient> getSalad() {
        return salad;
    }

    public Ingredient getIngredient(String name) {
        for (Ingredient ingredient : salad) {
            if (name.equals(ingredient.getName())) {
                return ingredient;
            }
        }
        return null;
    }
}


class SortByCalories implements Comparator<Ingredient> {
    public int compare(Ingredient ingredient1, Ingredient ingredient2) {
        return ingredient1.getCalories() - ingredient2.getCalories();
    }
}

class SortByWeight implements Comparator<Ingredient> {
    public int compare(Ingredient ingredient1, Ingredient ingredient2) {
        return ingredient1.getWeight() - ingredient2.getWeight();
    }
}