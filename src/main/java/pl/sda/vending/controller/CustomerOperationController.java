package pl.sda.vending.controller;

import pl.sda.vending.model.Tray;
import pl.sda.vending.model.VendingMachine;
import pl.sda.vending.util.StringUtil;

import java.util.Optional;

public class CustomerOperationController {
    private final VendingMachine machine;
    private final Integer trayWidth = 12;

    public CustomerOperationController(VendingMachine machine) {
        this.machine = machine;
    }

    public void printMachine() {
        for (int rowNo = 0; rowNo < machine.rowsCount(); rowNo++) {
            for (int colNo = 0; colNo < machine.colsCount(); colNo++) {
                printUpperBoundary(rowNo, colNo);
            }
            System.out.println();

            for (int colNo = 0; colNo < machine.colsCount(); colNo++) {
                printSymbol(rowNo, colNo);
            }
            System.out.println();

            for (int colNo = 0; colNo < machine.colsCount(); colNo++) {
                printName(rowNo, colNo);
            }
            System.out.println();

            for (int colNo = 0; colNo < machine.colsCount(); colNo++) {
                printPrice(rowNo, colNo);
            }
            System.out.println();

            for (int colNo = 0; colNo < machine.colsCount(); colNo++) {
                printLowerBoundary(rowNo, colNo);
            }
            System.out.println();
        }
    }

    private void printUpperBoundary(int rowNo, int colNo) {
        System.out.print("+" + StringUtil.duplicateText("-", trayWidth) + "+");
    }

    private void printSymbol(int rowNo, int colNo) {
        Optional<Tray> tray = machine.getTrayAtPosition(rowNo, colNo);
        String traySymbol = tray.map(Tray::getSymbol).orElse("--");
        System.out.print("|" + StringUtil.adjustText(traySymbol, trayWidth) + "|");
    }

    private void printPrice(int rowNo, int colNo) {
        Optional<Tray> tray = machine.getTrayAtPosition(rowNo, colNo);
        Long price = tray.map(Tray::getPrice).orElse(0L);
        String formattedMoney = StringUtil.formatMoney(price);
        String centeredMoney = StringUtil.adjustText(formattedMoney, trayWidth);
        System.out.print("|" + centeredMoney + "|");
    }

    private void printName(int rowNo, int colNo) {
        Optional<String> productPrice = machine.productNameAtPosition(rowNo, colNo);
        String formattedPrice = productPrice.orElse("--");
        System.out.print("|" + StringUtil.adjustText(formattedPrice, trayWidth) + "|");
    }

    private void printLowerBoundary(int rowNo, int colNo) {
        System.out.print("+" + StringUtil.duplicateText("-", trayWidth) + "+");
    }
}
