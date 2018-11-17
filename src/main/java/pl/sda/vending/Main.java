package pl.sda.vending;

import pl.sda.vending.controller.CustomerOperationController;
import pl.sda.vending.model.Product;
import pl.sda.vending.model.VendingMachine;
import pl.sda.vending.util.Configuration;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    Configuration configuration = new Configuration();
    VendingMachine vendingMachine = new VendingMachine(configuration);
    CustomerOperationController customerOperationController = new CustomerOperationController(vendingMachine);

    private void startApplication() {
        while (true) {
            customerOperationController.printMachine();
            printMenu();
            try {
                UserMenuSelection userSelection = getUserSelection();
                switch (userSelection) {
                    case BUY_PRODUCT:
                        // 1. pobierz symbol tacki
                        // 2. wywołaj metodę z controllera
                        //      Optional buyProductForSymbol(String traySymbol)
                        // 3. jeżeli się udało kupić:
                        //      Wypisz na ekran nazwę i potwierdzenie
                        // 4. jeżeli nie:
                        //      wypisz "brak produktu"
                        System.out.print("> Choose product symbol:");
                        String traySymbol = new Scanner(System.in).nextLine();
                        Optional<Product> bouoghtProduct = customerOperationController.buyProductForSymbol(traySymbol);
                        if (bouoghtProduct.isPresent()) {
                            System.out.println("Bought product: " + bouoghtProduct.get().getName());
                        } else {
                            System.out.println("No product available");
                        }
                        break;
                    case EXIT:
                        System.out.println("Bye bye maszkaro!");
                        return;
                    default:
                        System.out.println("Invalid selection");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid selection");
            }
        }
    }

    private void printMenu() {
        UserMenuSelection[] allPossibleSelections = UserMenuSelection.values();
        for (UserMenuSelection menuPosition : allPossibleSelections) {
            System.out.println(menuPosition.getOptionNumber() + ". " + menuPosition.getOptionText());
        }
    }

    private UserMenuSelection getUserSelection() {
        System.out.print(" > Your selection: ");
        String userSelection = new Scanner(System.in).nextLine();
        try {
            Integer menuNumber = Integer.valueOf(userSelection);
            return UserMenuSelection.selectionForOptionNumber(menuNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid selection format!");
        }
    }

    public static void main(String[] args) {
        new Main().startApplication();
    }
}
