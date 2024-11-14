package app.command;

import app.techservice.TechService;

public class OpenFridge implements Command {
    private TechService techService;

    public OpenFridge(TechService service) {
        this.techService = service;
    }

    @Override
    public void execute() {
        this.techService.openFridge();
    }

    @Override
    public String getDescription() {
        return "Open a fridge";
    }
}
