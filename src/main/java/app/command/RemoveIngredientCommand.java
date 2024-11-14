package app.command;

import app.saladservice.SaladService;

import java.util.Scanner;

public class RemoveIngredientCommand implements Command {
    private SaladService saladService;
    private Scanner scan;

    public RemoveIngredientCommand(SaladService service, Scanner scan) {
        this.saladService = service;
        this.scan = scan;
    }

    @Override
    public void execute() {
        System.out.print("Enter a name of ingredient which you want to remove: ");
        String name = scan.nextLine();
        saladService.removeIngredient(name);
    }

    @Override
    public String getDescription() {
        return "Remove an ingredient";
    }
}
