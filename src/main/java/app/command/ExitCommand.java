package app.command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("\nExit from program...");
    }

    @Override
    public String getDescription() {
        return "";
    }
}
