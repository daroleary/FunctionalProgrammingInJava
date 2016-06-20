package com.java8.collections;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.java8.collections.Folks.friends;

public class FilterDifferentNames {

    public static void main(String[] args) {

        final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);

        final long countFriendsStartN =
                friends.stream()
                        .filter(startsWithLetter.apply("N"))
                        .count();

        final long countFriendsStartB =
                friends.stream()
                        .filter(startsWithLetter.apply("B"))
                        .count();

        System.out.println(countFriendsStartN);
        System.out.println(countFriendsStartB);
    }
}
