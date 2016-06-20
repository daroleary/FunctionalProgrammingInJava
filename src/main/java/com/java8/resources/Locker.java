package com.java8.resources;

import java.util.concurrent.locks.Lock;

public class Locker {

    public static void runLocked(Lock lock, Runnable block) {
        lock.lock();

        try {
            block.run();
        } finally {
            lock.unlock();
        }
    }
}
