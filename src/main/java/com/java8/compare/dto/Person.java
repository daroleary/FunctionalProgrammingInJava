package com.java8.compare.dto;

public class Person {

    private final String _name;
    private final int _age;

    public Person(final String name,
                  final int age) {
        _name = name;
        _age = age;
    }

    public String getName() { return _name; }
    public int getAge() { return _age; }

    public int ageDifference(final Person other) {
        return _age - other._age;
    }

    public String toString() {
        return String.format("%s - %d", _name, _age);
    }
}
