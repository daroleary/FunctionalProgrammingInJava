package com.java8.applying;

public class PickStockParallel extends PickStockFunctional {
    public static void main(String[] args) {
        findHighPriced(Tickers.symbols.parallelStream());
    }
}
