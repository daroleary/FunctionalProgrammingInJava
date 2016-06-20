package com.java8.lazy;

public class Heavy {

    public Heavy() {
        System.out.println("Heavy created");
    }

    @Override
    public String toString() {
        return "quite heavy";
    }
}
