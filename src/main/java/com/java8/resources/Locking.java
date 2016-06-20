package com.java8.resources;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {

    Lock lock = new ReentrantLock(); // or mock

    protected void setLock(final Lock mock) {
        lock = mock;
    }

    public void doOp1() {
        lock.lock();
        try {
            //...critical code...
        } finally {
            lock.unlock();
        }
    }
    //..

    public void doOp2() {
        Locker.runLocked(lock, () -> {/*...critical code...*/});
    }

    public void doOp3() {
        Locker.runLocked(lock, () -> {/*...critical code...*/});
    }

    public void doOp4() {
        Locker.runLocked(lock, () -> {/*...critical code...*/});
    }
}
