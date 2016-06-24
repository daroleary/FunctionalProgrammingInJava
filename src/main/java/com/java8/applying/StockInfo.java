package com.java8.applying;

import java.math.BigDecimal;

public class StockInfo {

    private final String _ticker;
    private final BigDecimal _price;

    public StockInfo(final String symbol, final BigDecimal price) {
        _ticker = symbol;
        _price = price;
    }

    public String getTicker() {
        return _ticker;
    }

    public BigDecimal getPrice() {
        return _price;
    }

    public String toString() {
        return String.format("ticker: %s price: %g", _ticker, _price);
    }
}
