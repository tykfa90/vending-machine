package pl.sda.vending.controller;

import pl.sda.vending.model.VendingMachine;

public class CustomerOperationController {
    private VendingMachine machine;

    public CustomerOperationController() {
        machine = new VendingMachine();
    }

    public void printMachine() {
        for (int row = 0; row < machine.rowsCount(); row++) {
            for (int col = 0; col < machine.colsCount(); col++) {
                System.out.print("+--------+");
            }
            System.out.println();

            for (int col = 0; col < machine.colsCount(); col++) {
//                char symbolLetter = (char) ('A' + row);
//                int symbolNumber = col + 1;
                System.out.print("|   " + (char) (row + 1 + 64) + (col + 1) /* symbolLetter + symbolNumber */ + "   |");
            }
            System.out.println();
            for (int col = 0; col < machine.colsCount(); col++) {
                System.out.print("+--------+");
            }
            System.out.println();
        }
    }
}
