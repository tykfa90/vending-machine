package pl.sda.vending.model;

import pl.sda.vending.util.Configuration;

public class VendingMachine {

    private final Configuration configuration;

    public VendingMachine(Configuration configuration) {
        this.configuration = configuration;
    }

    public Long rowsCount() {
        return configuration.getLongProperty(
                "machine.size.rows",
                6L);
    }

    public Long colsCount() {
        return configuration.getLongProperty(
                "machine.size.cols",
                4L);
    }
}
