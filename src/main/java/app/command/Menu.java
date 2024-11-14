package app.command;

import java.util.HashMap;
import java.util.Map;

//Invoker
public class Menu {
    private Map<Integer, Command> commands = new HashMap<>();

    public void setCommand(Integer option, Command command) {
        commands.put(option, command);
    }

    public void executeCommand(Integer option) {
        Command command = commands.get(option);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid menu option");
        }
    }

    public void showMenu() {
        System.out.println("Menu:");
        int n = commands.size();
        for (int i = 1; i < n; i++) {
            System.out.println(i + ". " + (commands.get(i)).getDescription());
        }
        System.out.println("0. Exit");
    }

    public String getNameCommand(Integer option) {
        return commands.get(option).getDescription();
    }
}
