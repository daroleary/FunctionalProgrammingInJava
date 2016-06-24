package com.java8.applying;

import com.java8.designing.YahooFinance;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class StockUtil {

    public static StockInfo getPrice(final String ticker) {
        return new StockInfo(ticker, YahooFinance.getPrice(ticker));
    }

    public static Predicate<StockInfo> isPriceLessThan(final int price) {
        return stockInfo -> stockInfo.getPrice().compareTo(BigDecimal.valueOf(price)) < 0;
    }

    public static StockInfo pickHigh(final StockInfo stock1,
                                     final StockInfo stock2) {
        return stock1.getPrice().compareTo(stock2.getPrice()) > 0 ? stock1 : stock2;
    }
}
