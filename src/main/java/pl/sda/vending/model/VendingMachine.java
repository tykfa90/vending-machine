package pl.sda.vending.model;

import pl.sda.vending.util.Configuration;

public class VendingMachine {

    private final Configuration configuration;
    private Long rowsCount;
    private Long colsCount;

    public VendingMachine(Configuration configuration) {
        this.configuration = configuration;
        rowsCount = configuration.getLongProperty("machine.size.rows", 6L);
        if (rowsCount <= 0) {
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }
        colsCount = configuration.getLongProperty("machine.size.cols", 4L);
        if (colsCount <= 0) {
            throw new IllegalArgumentException("Row count " + colsCount + " is invalid");
        }
        if (rowsCount > 26) {
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }
        if (colsCount > 9) {
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
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
