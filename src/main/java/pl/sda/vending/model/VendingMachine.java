package pl.sda.vending.model;

import pl.sda.vending.util.Configuration;

import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.Array;
import java.util.Optional;
import java.util.Random;

public class VendingMachine {

    private final Configuration configuration;
    private Long rowsCount;
    private Long colsCount;
    private Tray[][] trays;

    public VendingMachine(Configuration configuration) {
        this.configuration = configuration;
        rowsCount = configuration.getLongProperty("machine.size.rows", 6L);
        colsCount = configuration.getLongProperty("machine.size.cols", 4L);
        if (rowsCount <= 0) {
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }
        if (colsCount <= 0) {
            throw new IllegalArgumentException("Row count " + colsCount + " is invalid");
        }
        if (rowsCount > 26) {
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }
        if (colsCount > 9) {
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }

        //stworzyć tablicę 2 wymiarową
        // do każdego pola tabliy wpisać nowy obiekt tacki
        // obiekt tacki mus mieć ustawiony poprawny symbol
        trays = new Tray[rowsCount.intValue()][colsCount.intValue()];

        for (int rowNo = 0; rowNo < rowsCount; rowNo++) {
            for (int colNo = 0; colNo < colsCount; colNo++) {
                if (Math.random() < 0.8) {
                    generateTrayAtPosition(rowNo, colNo);
                }
            }
        }
    }

    private void generateTrayAtPosition(int rowNo, int colNo) {
        Random random = new Random();
        long price = random.nextInt(901) + 100;
        char symbolLetter = (char) ('A' + rowNo);
        int symbolNumber = colNo + 1;
        String symbol = "" + symbolLetter + symbolNumber;
        int productProbability = random.nextInt(10);
        if (productProbability < 1) {
            Tray tray = Tray
                    .builder(symbol)
                    .price(price)
                    .product(new Product("Product " + symbol))
                    .product(new Product("Product " + symbol))
                    .build();
            trays[rowNo][colNo] = tray;
        } else if (productProbability < 0.5) {
            Tray tray = Tray
                    .builder(symbol)
                    .price(price)
                    .product(new Product("Product " + symbol))
                    .build();
            trays[rowNo][colNo] = tray;
        } else {
            Tray tray = Tray
                    .builder(symbol)
                    .price(price)
                    .build();
            trays[rowNo][colNo] = tray;
        }
    }

    public Optional<Tray> getTrayAtPosition(int rowNo, int colNo) {
        //zwróc tackę w optionalu
        // jak nie istnieje to pusty optional
        try {
            Tray tray = trays[rowNo][colNo];
            Optional<Tray> wrappedTray = Optional.ofNullable(tray);
            return wrappedTray;
        } catch (ArrayIndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public Long rowsCount() {
        rowsCount = configuration.getLongProperty(
                "machine.size.rows",
                6L);
        return rowsCount;
    }

    public Long colsCount() {
        return configuration.getLongProperty(
                "machine.size.cols",
                4L);
    }
}
