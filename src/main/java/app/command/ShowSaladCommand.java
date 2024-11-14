package app.command;

import app.saladservice.SaladService;

public class ShowSaladCommand implements Command {
    private SaladService saladService;

    public ShowSaladCommand(SaladService service) {
        this.saladService = service;
    }

    @Override
    public void execute() {
        saladService.showSalad();
    }

    @Override
    public String getDescription() {
        return "Show a salad";
    }
}
