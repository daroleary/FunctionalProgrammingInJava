package com.java8.applying;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class PickStockImperativeClubbed {

    public static void main(String[] args) {

        StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);
        final Predicate<StockInfo> isPricedLessThan500 = StockUtil.isPriceLessThan(500);

        for (String symbol : Tickers.symbols) {
            StockInfo stockInfo = StockUtil.getPrice(symbol);

            if (isPricedLessThan500.test(stockInfo)) {
                highPriced = StockUtil.pickHigh(highPriced, stockInfo);
            }
        }

        System.out.println("High priced under $500 is " + highPriced);
    }
}
