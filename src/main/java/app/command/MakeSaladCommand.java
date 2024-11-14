package app.command;

import app.saladservice.SaladService;
import app.techservice.TechService;

import java.util.Scanner;

public class MakeSaladCommand implements Command {
    private SaladService saladService;
    private TechService techService;
    private Scanner scan;

    public MakeSaladCommand(SaladService service, TechService techService, Scanner scan) {
        this.saladService = service;
        this.techService = techService;
        this.scan = scan;
    }

    @Override
    public void execute() {
        System.out.print("Enter a name of salad: ");
        String name = scan.nextLine();
        saladService.makeSalad(name, this.techService);
    }

    @Override
    public String getDescription() {
        return "Make a salad";
    }
}
