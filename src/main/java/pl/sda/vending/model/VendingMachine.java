package pl.sda.vending.model;

import pl.sda.vending.util.Configuration;

import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.Array;
import java.util.Optional;

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
                char symbolLetter = (char) ('A' + rowNo);
                int symbolNumber = colNo +1;
                String symbol = "" + symbolLetter + symbolNumber;
                trays[rowNo][colNo] = new Tray(symbol);
            }
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
