package app.command;

import app.saladservice.SaladService;

import java.util.Scanner;

public class SortIngredientsCommand implements Command{
    private SaladService saladService;
    private Scanner scan;

    public SortIngredientsCommand(SaladService service, Scanner scan) {
        this.saladService = service;
        this.scan = scan;
    }

    @Override
    public void execute() {
        System.out.println("1. Calories");
        System.out.println("2. Weight");
        System.out.print("Select the parameter by which you want to sort: ");
        int choice = scan.nextInt();
        if (choice == 1 || choice == 2){
            saladService.sortIngredients(choice);
        }
        else
            System.out.println("Incorrect parameter selected");
    }

    @Override
    public String getDescription() {
        return "Sort ingredients";
    }
}
