package com.java8.collections;

import java.text.MessageFormat;
import java.util.Optional;

import static com.java8.collections.Folks.friends;

public class PickTheLongest {

    public static void main(String[] args) {

        System.out.println("Total number of characters in all names: " +
                friends.stream()
                        .mapToInt(String::length)
                        .sum());

        Optional<String> aLongName = friends.stream()
                .reduce((name1, name2) ->
                        name1.length() >= name2.length() ? name1 : name2);

        aLongName.ifPresent(name -> System.out.println(
                MessageFormat.format("The longest name {0}", name)));

        String steveOrLonger = friends.stream()
                .reduce("Steve", (name1, name2) ->
                        name1.length() >= name2.length() ? name1 : name2);

        System.out.println(steveOrLonger);
    }
}
