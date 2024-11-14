package app.main;

import app.command.*;
import app.emailservice.EmailService;
import app.saladservice.SaladService;
import app.techservice.TechService;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final EmailService emailservice = new EmailService();

    public static void main(String[] args) {
        logger.info("Програму запущено!");

        Scanner scanner = new Scanner(System.in);
        SaladService saladService = new SaladService();
        TechService techService = new TechService();
        Menu menu = new Menu();

        menu.setCommand(1, new AddIngredientCommand(saladService, scanner));
        menu.setCommand(2, new RemoveIngredientCommand(saladService, scanner));
        menu.setCommand(3, new CalculateCaloriesCommand(saladService));
        menu.setCommand(4, new ShowSaladCommand(saladService));
        menu.setCommand(5, new SortIngredientsCommand(saladService, scanner));
        menu.setCommand(6, new MakeSaladCommand(saladService, techService, scanner));
        menu.setCommand(7, new OpenFridge(techService));
        menu.setCommand(0, new ExitCommand());

        Integer option;

        do {
            System.out.println("-----------------------");
            menu.showMenu();
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            System.out.println("-----------------------");
            try {
                menu.executeCommand(option);
                logger.info("Виконано команду: " + menu.getNameCommand(option));
                //throw new RuntimeException("Виявлено критичну помилку!");
            } catch (Exception e) {
                logger.error("Критична помилка: ", e);
                emailservice.sendErrorEmail("Критична помилка у програмі!", e.getMessage());
            }
        } while (!option.equals(0));
        logger.info("Завершення програми!");
    }
}
