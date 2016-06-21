package com.java8.recursion;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigFactorial {

    public static BigInteger decrement(final BigInteger number) {
        return number.subtract(ONE);
    }

    public static BigInteger multiply(final BigInteger first,
                                      final BigInteger second) {
        return first.multiply(second);
    }

    final static BigInteger ONE = BigInteger.ONE;
    final static BigInteger FIVE = new BigInteger("5");
    final static BigInteger TWENTYK = new BigInteger("20000");

    //...

    private static TailCall<BigInteger> factorialTailRec(final BigInteger factorial,
                                                         final BigInteger number) {
        if (number.equals(ONE)) {
            return TailCalls.done(factorial);
        } else {
            return TailCalls.call(() ->
                    factorialTailRec(multiply(factorial, number), decrement(number)));
        }
    }

    public static BigInteger factorial(final BigInteger number) {
        return factorialTailRec(ONE, number).invoke();
    }

    public static void main(String[] args) {
        System.out.println(factorial(FIVE));
        System.out.println(String.format("%.10s...", factorial(TWENTYK)));
    }
}
