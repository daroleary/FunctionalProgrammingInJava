package com.java8.designing;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CalculateNAVTest {

    @Test
    public void test() {

        CalculateNAV calculateNAV =
                new CalculateNAV(ticker -> new BigDecimal("6.01"));

        BigDecimal expectedStockPriceTotal = new BigDecimal("6010.00");
        assertEquals(
                0,
                calculateNAV.computeStockWorth("GOOG", 1000).compareTo(expectedStockPriceTotal),
                0.000001);
    }
}
