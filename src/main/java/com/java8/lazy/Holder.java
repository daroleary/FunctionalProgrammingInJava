package com.java8.lazy;

import java.util.function.Supplier;

public class Holder {

    private Supplier<Heavy> heavy = () -> createAndCacheHeavy();

    public Holder() {
        System.out.println("Holder created");
    }

    public Heavy getHeavy() {
        return heavy.get();
    }

    private synchronized Heavy createAndCacheHeavy() {

        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavyInstance = new Heavy();

            public Heavy get() {
                return heavyInstance;
            }
        }

        if (!HeavyFactory.class.isInstance(heavy)) {
            heavy = new HeavyFactory();
        }

        return heavy.get();
    }

    public static void main(String[] args) {

        final Holder holder = new Holder();

        System.out.println("deferring heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());

        // avoid duplicate instantiation
        // multiple threads cannot create their own instances if called at same time
        // overhead avoided on every call to getHeavy due to synchronization. Only occurs on first call as Heavy becomes a HeavyFactory once instantiated.
    }
}
