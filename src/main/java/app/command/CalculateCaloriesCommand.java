package app.command;

import app.saladservice.SaladService;

public class CalculateCaloriesCommand implements Command{
    private SaladService saladService;

    public CalculateCaloriesCommand(SaladService service) {
        this.saladService = service;
    }

    @Override
    public void execute() {
        saladService.calculateCalories();
    }

    @Override
    public String getDescription() {
        return "Calculate calories";
    }
}
