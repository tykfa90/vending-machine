package pl.sda.vending.model;

import sun.awt.Symbol;

public class Tray {
    private String symbol;
    private Long price;

    private Tray(Builder builder) {
        symbol = builder.symbol;
        price = builder.price;
    }

    public static Builder builder(String symbol) {
        return new Builder(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    public Long getPrice() {
        return price;
    }

    public static class Builder {
        private String symbol;
        private Long price;

        private Builder(String symbol) {
            this.symbol = symbol;
        }

        public Builder price(Long price) {
            this.price = price;
            return this;
        }

        public Tray build() {
            if (price == null || price < 0) {
                price = 0L;
            }
            return new Tray(this);
        }
    }
}
