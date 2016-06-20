package com.java8.designing;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {

    private Function<String, BigDecimal> _priceFinder;

    public BigDecimal computeStockWorth(final String ticker,
                                        final int shares) {
        return _priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    public CalculateNAV(final Function<String, BigDecimal> priceFinder) {
        _priceFinder = priceFinder;
    }

    public static void main(String[] args) {
        CalculateNAV calculateNAV = new CalculateNAV(YahooFinance::getPrice);

        System.out.println(String.format("100 shares of Google worth: $%.2f",
                calculateNAV.computeStockWorth("GOOG", 100)));
    }
}
