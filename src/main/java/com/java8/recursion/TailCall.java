package com.java8.recursion;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall<T> {

    TailCall<T> apply();

    default boolean isComplete() {
        return false;
    }
    //...

    default T result() {
        throw new NotImplementedException();
    }

    default T invoke() {
        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::isComplete)
                .findFirst()
                .get()
                .result();
    }
}
