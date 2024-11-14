package app.command;

import app.ingredient.Fruit;
import app.ingredient.Meat;
import app.ingredient.Vegetable;
import app.saladservice.SaladService;

import java.util.Scanner;

public class AddIngredientCommand implements Command{
    private SaladService saladService;
    protected Scanner scan;

    public AddIngredientCommand(SaladService service, Scanner scan) {
        this.saladService = service;
        this.scan = scan;
    }

    @Override
    public void execute() {
        System.out.println("1. Vegetable");
        System.out.println("2. Fruit");
        System.out.println("3. Meat");
        System.out.print("Choose ingredient: ");
        int choose = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter a name of ingredient: ");
        String name = scan.nextLine();
        System.out.print("Enter a calories of ingredient: ");
        int calories = scan.nextInt();
        System.out.print("Enter a weight of ingredient(in grams): ");
        int weight = scan.nextInt();
        switch (choose) {
            case (1):
                saladService.addIngredient(new Vegetable(name, calories, weight));
                break;
            case (2):
                saladService.addIngredient(new Fruit(name, calories, weight));
                break;
            case (3):
                saladService.addIngredient(new Meat(name, calories, weight));
                break;
            default:
                System.out.println("Error! Incorrect choose!");
        }
    }

    @Override
    public String getDescription() {
        return "Add an ingredient";
    }
}
