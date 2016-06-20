package com.java8.collections;

import java.util.stream.Collectors;

import static com.java8.collections.Folks.friends;

public class JoiningElements {

    public static void main(String[] args) {

        System.out.println(
        friends.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", ")));
    }
}
