package com.java8.applying;

import com.java8.designing.YahooFinance;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class Stocks100 {

    public static void main(String[] args) {

        final BigDecimal HUNDRED = new BigDecimal("100");

        System.out.println("Stocks priced over $100 are " +
                Tickers.symbols
                .stream()
                .filter(
                        symbol -> YahooFinance.getPrice(symbol).compareTo(HUNDRED) > 0)
                .sorted()
                .collect(Collectors.joining(", ")));
    }
}
