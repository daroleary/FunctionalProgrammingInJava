package com.java8.lazy;

public class HolderThreadSafe {

    private Heavy heavy;

    public HolderThreadSafe() {
        System.out.println("Holder created");
    }

    public synchronized Heavy getHeavy() {
        if (heavy == null) {
            heavy = new Heavy();
        }
        return heavy;
    }

    //...

    public static void main(String[] args) {

        final HolderThreadSafe holder = new HolderThreadSafe();
        System.out.println("deferring heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());

        // avoid duplicate instantiation
        // multiple threads cannot create their own instances if called at same time
        // overhead introduced on every call to getHeavy due to synchronization.
    }
}
